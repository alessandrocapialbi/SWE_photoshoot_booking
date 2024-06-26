package com.SWE_photoshoot_booking.services.impl;

import com.SWE_photoshoot_booking.domain.entities.AppointmentEntity;
import com.SWE_photoshoot_booking.repositories.AppointmentRepository;
import com.SWE_photoshoot_booking.services.AbstractCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class AppointmentService extends AbstractCrudService<AppointmentEntity, AppointmentRepository> {

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        super(appointmentRepository);
    }

    @Override
    public AppointmentEntity partialUpdate(UUID id, AppointmentEntity entity) {
        entity.setAppointmentID(id);
        return getRepository().save(entity);
    }

    public List<AppointmentEntity> findAllByUser(UUID userID) {
        return getRepository().findAllByCustomer_UserID(userID);
    }

    public Optional<AppointmentEntity> findByTimeSlot(UUID id) {
        return getRepository().findAllByTimeslot_TimeslotID(id);
    }
}