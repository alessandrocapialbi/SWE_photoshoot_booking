package com.SWE_photoshoot_booking.controllers;

import com.SWE_photoshoot_booking.domain.dto.AppointmentDto;
import com.SWE_photoshoot_booking.domain.entities.Role;
import com.SWE_photoshoot_booking.domain.entities.UserEntity;
import com.SWE_photoshoot_booking.services.impl.AppointmentService;
import com.SWE_photoshoot_booking.services.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class CustomerDashboardController {


    private final UserService userService;

    private final AppointmentService appointmentService;

    @Autowired
    public CustomerDashboardController(UserService userService, AppointmentService appointmentService) {
        this.userService = userService;
        this.appointmentService = appointmentService;
    }


    @GetMapping("/customer-dashboard")
    public String showUserDashboard(Model model, Principal principal) {
        UserEntity customer = userService.findCustomerByEmail(principal.getName());
        model.addAttribute("customerName", customer.getName());
        return "customer-dashboard";
    }

    @GetMapping("/book-appointment")
    public String showBookAppointmentPage(Model model, Principal principal) {
        AppointmentDto appointment = new AppointmentDto();
        UserEntity customer = userService.findCustomerByEmail(principal.getName());
        appointment.setCustomer(customer.getUserID());
        model.addAttribute("appointment", appointment);
        Pageable firstPageWithTenElements = PageRequest.of(0, 10);
        model.addAttribute("photographers", userService.findAllByRole(Role.PHOTOGRAPHER, firstPageWithTenElements));
        return "book-appointment";
    }

    @GetMapping("/view-appointments")
    public String showViewAppointmentsPage(Model model, Principal principal) {
        UserEntity customer = userService.findCustomerByEmail(principal.getName());
        model.addAttribute("appointments", appointmentService.findAllByUser(customer.getUserID()));
        return "view-appointments";
    }

}
