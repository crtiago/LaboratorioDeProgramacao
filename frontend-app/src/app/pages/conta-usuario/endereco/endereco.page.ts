import { Component, OnInit } from "@angular/core";
import { FormGroup, FormBuilder, Validators, FormControl } from "@angular/forms";
import { CidadeEstadoService } from 'src/services/domain/cidade-estado.service';
import { CidadeDTO } from 'src/models/cidade.dto';
import { EstadoDTO } from 'src/models/estado.dto';
import { UserRepository } from 'src/app/shared/globalData/user.service';
import { EnderecoService } from 'src/services/domain/endereco.service';
import { EnderecoDTO } from 'src/models/endereco.dto';

@Component({
  selector: "app-endereco",
  templateUrl: "./endereco.page.html",
  styleUrls: ["./endereco.page.scss"]
})
export class EnderecoPage implements OnInit {
  enderecoForm: FormGroup;
  cidades: CidadeDTO[];
  estados: EstadoDTO[];
  endereco: EnderecoDTO = {
    bairro: '',
    cep: '',
    numero: 0,
    id: '',
    rua: '',
    cidade: {id: '', nome: '', estado: {id: '', nome: ''}}
  };
  idUser: number;

  constructor(private fb: FormBuilder,
              private cidEstService: CidadeEstadoService,
              private userRepo: UserRepository,
              private endService: EnderecoService) {}

  ngOnInit() {
    this.createForm();
    this.cidEstService.findEstado().subscribe(res => {
      this.estados = res;
    });
    //this.idUser = this.userRepo.getUser().id;
    this.idUser = 1;

  }

  private createForm() {
    this.enderecoForm = this.fb.group({
      rua: ["", [Validators.required, Validators.minLength(10)]],
      cep: ["", [Validators.required, Validators.minLength(8), Validators.maxLength(8)]],
      numero: ["", [Validators.required]],
      bairro: ["", [Validators.required, Validators.minLength(6)]],
      estadoId: ["",[Validators.required]],
      cidadeId: ["",[Validators.required]]
    });
  }

  updateCidades() {
    const estadoId = this.estadoId.value;
    this.cidEstService.findCidadeAll(estadoId ).subscribe(res =>{
      this.cidades = res;
    });
  }


  onSubmit(): void {
    this.setAdress();
    console.log(this.endereco);
    this.endService.registerAdress(this.endereco, this.idUser);
  }


  private setAdress(){
    this.endereco.rua = this.rua.value;
    this.endereco.cep = this.cep.value;
    this.endereco.numero = this.numero.value;
    this.endereco.bairro = this.bairro.value;
    this.endereco.cidade = this.cidades.find(x => x.id == this.cidadeId.value);
    this.endereco.cidade.estado = this.estados.find(x => x.id == this.estadoId.value);
  }

  get rua(): FormControl {
    return <FormControl>this.enderecoForm.get("rua");
  }
  get cep(): FormControl {
    return <FormControl>this.enderecoForm.get("cep");
  }
  get numero(): FormControl {
    return <FormControl>this.enderecoForm.get("numero");
  }
  get bairro(): FormControl {
    return <FormControl>this.enderecoForm.get("bairro");
  }
  get estadoId(): FormControl{
    return <FormControl>this.enderecoForm.get("estadoId");
  }
  get cidadeId(): FormControl{
    return <FormControl>this.enderecoForm.get("cidadeId");
  }

}
