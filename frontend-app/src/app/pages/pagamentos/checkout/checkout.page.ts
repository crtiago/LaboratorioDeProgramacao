import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.page.html',
  styleUrls: ['./checkout.page.scss'],
})
export class CheckoutPage implements OnInit {

  payMethodCard: boolean = false;
  constructor() { }

  ngOnInit() {
  }


  segmentChanged(ev: any) {
    this.payMethodCard = !this.payMethodCard;
  }

}
