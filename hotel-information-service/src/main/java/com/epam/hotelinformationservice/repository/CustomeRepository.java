package com.epam.hotelinformationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epam.hotelinformationservice.entity.HotelInfo;

public interface CustomeRepository extends JpaRepository<HotelInfo,Long> {

}
