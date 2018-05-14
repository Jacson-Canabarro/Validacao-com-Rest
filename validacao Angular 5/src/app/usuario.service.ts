import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable()
export class UsuarioService {
  private uri:string="http://localhost:8080/cadastrarUsuario";
  private httpheaders={headers: new HttpHeaders({'Content-type':'application/json'})};

  constructor(private _http:HttpClient) { }


  cadastrarUsu(usuario){
    return this._http.post(this.uri,usuario,this.httpheaders);
  }

}
