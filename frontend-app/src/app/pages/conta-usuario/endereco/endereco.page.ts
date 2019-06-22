import { Component, OnInit } from "@angular/core";
import { FormGroup, FormBuilder, Validators, FormControl } from "@angular/forms";

@Component({
  selector: "app-endereco",
  templateUrl: "./endereco.page.html",
  styleUrls: ["./endereco.page.scss"]
})
export class EnderecoPage implements OnInit {
  enderecoForm: FormGroup;

  constructor(private fb: FormBuilder) {}

  ngOnInit() {
    this.createForm();
  }

  private createForm() {
    this.enderecoForm = this.fb.group({
      rua: ["", [Validators.required, Validators.minLength(5)]],
      cep: ["", [Validators.required, Validators.email]],
      numero: ["", [Validators.required, Validators.minLength(6)]],
      bairro: ["", [Validators.required, Validators.minLength(11)]]
    });
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
}
