package com.deep.tripease.service;

import com.deep.tripease.dto.request.BookingRequest;
import com.deep.tripease.dto.response.BookingResponse;
import com.deep.tripease.exception.CabNotAvailableException;
import com.deep.tripease.exception.CustomerNotFoundException;
import com.deep.tripease.model.Booking;
import com.deep.tripease.model.Cab;
import com.deep.tripease.model.Customer;
import com.deep.tripease.model.Driver;
import com.deep.tripease.repository.BookingRepository;
import com.deep.tripease.repository.CabRepository;
import com.deep.tripease.repository.CustomerRepository;
import com.deep.tripease.repository.DriverRepository;
import com.deep.tripease.transformer.BookingTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CabRepository cabRepository;
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private JavaMailSender javaMailSender;

    /**
     * Cab booking
     * Check user in db
     * Random available cab using cabRepo
     * Save booking object
     * After add booking in customer table
     * Get a driver by cabId then update bookings
     * Send email to the customer
     * Save all-changes return responses
     * */
    public ResponseEntity<BookingResponse> cabBooking(BookingRequest bookingRequest, int customerId) {
        Optional<Customer> optionalCustomer=customerRepository.findById(customerId);
        if(optionalCustomer.isEmpty()){
            throw new CustomerNotFoundException("Invalid customer id");
        }
        Customer customer=optionalCustomer.get();

        Cab availableCab=cabRepository.findAvailableCabRandom();
        if(availableCab==null){
            throw new CabNotAvailableException("Sorry cab not available try some time latter");
        }

        Booking booking= BookingTransformer.BookingRequestToBooking(bookingRequest,availableCab.getParKmRate());
        Booking savedBooking=bookingRepository.save(booking);
        availableCab.setAvailable(false);
        customer.getBookings().add(savedBooking);

        Driver driver=driverRepository.findDriverByCabId(availableCab.getCabId());
        driver.getBookings().add(savedBooking);

        Driver savedDriver=driverRepository.save(driver);
        Customer savedCustomer=customerRepository.save(customer);

        sendEmail(savedCustomer,savedBooking);

        BookingResponse finalBookingResponse=BookingTransformer.BookingToBookingResponse(savedBooking,savedCustomer,availableCab,savedDriver);
        return new ResponseEntity<>(finalBookingResponse,HttpStatus.CREATED);
    }

    /**
     * Set all email attribute
     * Using the inbuilt class for setting email attribute(SimpleMailMessage)
     * Create the object of class set attribute
     * After this call the javaMailSender.SEND(passSimpleMailMessageObject) method
     * Set the proper booking message
     */
    private void sendEmail(Customer savedCustomer,Booking savedBooking) {
        final String supportEmail = "devbackend36@gmail.com";
        final String supportPhone = "+91-6386448975";
        final String websiteUrl = "https://www.tripease.com";

        StringBuilder infoMessage = new StringBuilder();
        infoMessage.append("Congratulations!\n\n")
                .append("Dear ").append(savedCustomer.getName()).append(",\n\n")
                .append("Thank you for booking your ride with TrieEase! Below are the details of your trip:\n\n")
                .append("🚗 Ride Details:\n")
                .append("• Pickup Location: ").append(savedBooking.getPickup()).append("\n")
                .append("• Destination: ").append(savedBooking.getDestination()).append("\n")
                .append("• Distance: ").append(String.format("%.2f KM", savedBooking.getTripDistanceInKm())).append("\n")
                .append("• Total Bill: ₹").append(String.format("%.2f", savedBooking.getBillAmount())).append("\n\n")
                .append("Your cab will arrive shortly before your scheduled pickup time.\n")
                .append("If you need to make any changes or cancel the ride, please contact us at ").append(supportEmail).append(".\n\n")
                .append("We appreciate your trust in us and wish you a pleasant journey!\n\n")
                .append("Best regards,\n")
                .append("TrieEase Team\n")
                .append("Customer Support\n")
                .append(supportPhone).append(" | ").append(supportEmail).append(" | ").append(websiteUrl);

        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setFrom("devbackend36@gmail.com");
        simpleMailMessage.setTo(savedCustomer.getEmailId());
        simpleMailMessage.setSubject("Ride Booking Confirmation "+savedCustomer.getName());
        simpleMailMessage.setText(infoMessage.toString());
        javaMailSender.send(simpleMailMessage);
    }

    public ResponseEntity<?> getAllBookings() {
        List<Booking> booking=bookingRepository.findAll();
       return new ResponseEntity<>(booking,HttpStatus.OK);
    }
}
