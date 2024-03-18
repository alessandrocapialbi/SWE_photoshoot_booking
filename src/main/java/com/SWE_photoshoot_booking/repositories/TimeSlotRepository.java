package com.SWE_photoshoot_booking.repositories;

import com.SWE_photoshoot_booking.domain.TimeSlot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeSlotRepository extends CrudRepository<TimeSlot, Long> {
}
