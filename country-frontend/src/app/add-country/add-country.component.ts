import { Component, OnInit } from '@angular/core';

import { HttpClientService, Country } from '../service/http-client.service'

@Component({
  selector: 'app-add-country',
  templateUrl: './add-country.component.html',
  styleUrls: ['./add-country.component.css']
})
export class AddCountryComponent implements OnInit {

  country: Country = new Country(null, "", "", null);

  constructor(private httpClientService: HttpClientService) { }

  ngOnInit() {
  }

  createCountry() {
    this.httpClientService.createCountry(this.country).subscribe(
      country => {
        alert("Country created successfully.")
      }
    )
  }
}
