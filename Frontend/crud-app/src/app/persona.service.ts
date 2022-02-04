import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {HttpClient} from '@angular/common/http';
import { Persona } from './persona';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PersonaService {
  private ApiUrl = environment.ApiUrl;

  constructor(private http: HttpClient) { }

  public getPersonas(): Observable<Persona[]> {
    return this.http.get<Persona[]>(`${this.ApiUrl}/persona/verpersonas`);
  }

  public addPersona(persona: Persona): Observable<string> {
    return this.http.post<string>(`${this.ApiUrl}/persona/insertarpersona`,persona);
  }

  public updatePersona(persona: Persona,idPersona: number): Observable<string> {
    return this.http.put<string>(`${this.ApiUrl}/persona/actualizarpersonas/${idPersona}`,persona);
  }

  public deletePersona(idPersona: number): Observable<string> {
    return this.http.delete<string>(`${this.ApiUrl}/persona/borrarpersona/${idPersona}`);
  }



}
