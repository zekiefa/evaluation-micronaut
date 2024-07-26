package br.com.cvc.evaluation.domain;

import java.io.Serializable;
import java.util.List;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Hotel(Integer id, String cityName, String name, List<Room> rooms) implements Serializable {

}
