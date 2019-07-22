package com.example.countrybackend.controller;

import com.example.countrybackend.domain.Country;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({ "/countries" })
public class CountryController {

    private List<Country> countries;

    @PostConstruct
    public void createCountries() {
        this.countries = new ArrayList<>();
        this.countries.addAll(Arrays.asList(
                Country.fromName("Brasil"),
                Country.fromName("Argentina"),
                Country.fromName("Chile"),
                Country.fromName("Canada"),
                Country.fromName("Republica Democratica do Congo"),
                Country.fromName("Ruanda"),
                Country.fromName("Uganda"),
                Country.fromName("Namibia"),
                Country.fromName("Botsuana"),
                Country.fromName("Islandia"),
                Country.fromName("Nova Zelandia")
        ));
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<Country> getCountries() {
        return this.countries;
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Country delete(@PathVariable("id") final Integer id) {
        final Country toBeRemoved = this.countries.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
        if (toBeRemoved != null) {
            this.countries.remove(toBeRemoved);
        }
        return toBeRemoved;
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Country create(@RequestBody final Country country) {
        this.countries.add(country);
        return country;
    }
}
