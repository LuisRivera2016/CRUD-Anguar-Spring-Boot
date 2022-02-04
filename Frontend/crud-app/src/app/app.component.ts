import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Persona } from './persona';
import { PersonaService } from './persona.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  
  public personas: Persona[];
  public editPeople: Persona;
  public deletePeople: Persona;

  constructor(private personaService: PersonaService){}

  ngOnInit() {
      this.getPersonas();
  }

 
  public getPersonas():void { 
    this.personaService.getPersonas().subscribe(
        (response: Persona[]) => {
          this.personas = response;
        },
        (error: HttpErrorResponse) => {
            alert(error.message);
        }
      );
  }

  public onOpenModal(persona: Persona, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addPeopleModal');
    }
    if (mode === 'edit') {
      this.editPeople = persona;
      button.setAttribute('data-target', '#updatePeopleModal');
    }
    if (mode === 'delete') {
      this.deletePeople = persona;
      button.setAttribute('data-target', '#deletePeopleModal');
    }
    container.appendChild(button);
    button.click();
  }

  public onAddPeople(addForm: NgForm): void {
    document.getElementById('add-people-form').click();
    this.personaService.addPersona(addForm.value).subscribe(
      (response: string) => {
        console.log(response);
        this.getPersonas();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onUpdatePeople(persona: Persona,idPersona:number): void {
    this.personaService.updatePersona(persona,idPersona).subscribe(
      (response: string) => {
        console.log(response);
        this.getPersonas();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeletePeople(idPersona: number): void {
    this.personaService.deletePersona(idPersona).subscribe(
      (response: string) => {
        console.log(response);
        this.getPersonas();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public searchPeoples(key: string): void {
    console.log(key);
    const results: Persona[] = [];
    for (const persona of this.personas) {
      if (persona.nombre.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || persona.apellido.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || persona.telefono.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || persona.email.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
        results.push(persona);
      }
    }
    this.personas = results;
    if (results.length === 0 || !key) {
      this.getPersonas();
    }
  }

}
