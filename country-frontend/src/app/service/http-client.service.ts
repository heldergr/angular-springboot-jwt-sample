import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

export class Country {
  constructor(
    public id: number,
    public name: string,
    public capital: string,
    public population: number
  ) {}
}

const COUNTRIES_URL = 'http://localhost:8080/countries'

@Injectable({
  providedIn: 'root'
})
export class HttpClientService {

  constructor(private httpClient: HttpClient) { }

  getCountries() {
    return this.httpClient.get<Country[]>(COUNTRIES_URL);
  }

  deleteCountry(country: Country) {
    return this.httpClient.delete<Country>(`${COUNTRIES_URL}/${country.id}`)
  }

  createCountry(country: Country) {
    return this.httpClient.post<Country>(COUNTRIES_URL, country)
  }
}
