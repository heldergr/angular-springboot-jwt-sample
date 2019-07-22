import { Component, OnInit } from '@angular/core';

import { Country, HttpClientService } from '../service/http-client.service'

@Component({
  selector: 'app-country',
  templateUrl: './country.component.html',
  styleUrls: ['./country.component.css']
})
export class CountryComponent implements OnInit {

  countries: Country[] = []

  constructor(private httpClientService: HttpClientService) { }

  ngOnInit() {
    this.httpClientService.getCountries().subscribe(
      response => this.handleSuccessfulResponse(response)
    )
  }

  deleteCountry(country: Country) {
    this.httpClientService.deleteCountry(country).subscribe(
      country => {
        this.countries = this.countries.filter(c => c.id !== country.id)
      }
    )
  }

  handleSuccessfulResponse(response) {
    this.countries = response
  }
}
