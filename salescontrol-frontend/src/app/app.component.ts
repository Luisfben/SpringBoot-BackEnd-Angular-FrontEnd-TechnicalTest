import { Component } from '@angular/core';
import { ProductDTO } from 'src/app/model/productDTO';
import { typeWithParameters } from '@angular/compiler/src/render3/util';
import { FormGroup, FormControl } from '@angular/forms';
import { Client } from 'src/app/model/client';
import { SaleClientDTO } from './model/SaleClientDTO';
import { Router } from '@angular/router';
import { ServiceService } from './service/service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'salescontrol-frontend';
  
  constructor(private service:ServiceService){}

  products:ProductDTO[] = new Array();
  product:ProductDTO;
  newProduct:ProductDTO;

  productList:ProductDTO[] = new Array();
  productTemp:ProductDTO;
  productItemTotal:number;
  productGrandTotal:number=0;
    
  clients:Client[] = new Array();
  client:Client;
  clientSelected:Client;
  clientName:String;
  clientId:number;

  saleClient:SaleClientDTO;

  profileForm = new FormGroup({
    id: new FormControl(''),
    description: new FormControl(''),
    price: new FormControl(''),
    quantity: new FormControl('')
  });
  
  ngOnInit() {
    this.service.getClient()
    .subscribe(data=>{
      this.clients=data;
    })

    this.service.getProductInStock()
    .subscribe(data=>{
      this.productList=data;
    })
  }

  addProduct(){
    this.newProduct = new ProductDTO();
    this.newProduct.id=this.profileForm.get('id').value;
    this.newProduct.description=this.profileForm.get('description').value;
    this.newProduct.quantity=this.profileForm.get('quantity').value;
    this.newProduct.price=this.profileForm.get('price').value;
    this.products.push(this.newProduct);
    this.productGrandTotal = this.productGrandTotal + this.productItemTotal;
  }

  deleteProduct(product:ProductDTO){
    var i = this.products.indexOf(product);
    if ( i !== -1 ) {
      this.products.splice( i, 1 );
    }
    this.productGrandTotal = this.productGrandTotal - (product.price * product.quantity);
  }

  captureClientSelected(){
    var client = this.clients.find(client => client.id == this.clientId);
    this.clientSelected = client;
    this.clientName=client.name;
  }

  captureProductSelected(){
    var product = this.productList.find(product => product.id == this.profileForm.get('id').value);
    this.profileForm.setValue({id: product.id, description: product.description, price: product.price, quantity:1});
    this.calculateProductItemTotal();
  }

  calculateProductItemTotal(){
    this.productItemTotal = this.profileForm.get('price').value * this.profileForm.get('quantity').value;
  }

  save(){
    this.saleClient = new SaleClientDTO();
    this.saleClient.client = this.clientSelected;
    this.saleClient.products = this.products;
    console.warn(this.saleClient);
    console.warn(this.saleClient.products);
    console.warn(this.saleClient.client);
    
    this.service.setSalesClient(this.saleClient)
    .subscribe(data=>{
      alert(["It was saved successfully!"]);
    })
    
  }
}
