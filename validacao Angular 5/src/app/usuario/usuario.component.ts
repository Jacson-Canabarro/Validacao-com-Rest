import { UsuarioService } from './../usuario.service';
import { Component, OnInit } from '@angular/core';
import {Usuario} from '../usuario';


@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css']
})
export class UsuarioComponent implements OnInit {
  private usuario = new Usuario();
  private usuarioError: Usuario;
  private isCadastrado: boolean= false;
  private usuarioExist:boolean = false;

  constructor(private _usuarioService:UsuarioService) { }
  

  ngOnInit() {
  }

  cadastrar(){
    this._usuarioService.cadastrarUsu(this.usuario).subscribe(
      data=>{
          console.log(data);
          this.usuario= new Usuario();
          this.isCadastrado=true;
          this.usuarioExist=false;
          this.usuarioError = new Usuario();
    },
    error=>{
      this.usuarioError=error.error;
      this.isCadastrado=false;
      if(error.status==409){
        this.isCadastrado=false;
        this.usuarioExist=true;
        
      }
      
      console.log(error);
    }
  
  )

  }

}
