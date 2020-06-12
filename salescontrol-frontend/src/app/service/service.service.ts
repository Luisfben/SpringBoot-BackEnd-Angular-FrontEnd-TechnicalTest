import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Client } from '../model/client';
import { ProductDTO } from '../model/ProductDTO';
import { SaleClientDTO } from '../model/SaleClientDTO';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http:HttpClient) { }

  urlClient='http://localhost:8080/api/v1/client';
  urlProductInStock='http://localhost:8080/api/v1/productinstock';
  urlSalesClient='http://localhost:8080/api/v1/saleclient';

  getClient(){
    return this.http.get<Client[]>(this.urlClient);
  }

  getProductInStock(){
    return this.http.get<ProductDTO[]>(this.urlProductInStock);
  }

  setSalesClient(saleClient:SaleClientDTO){
    return this.http.post<SaleClientDTO>(this.urlSalesClient,saleClient);

  }

}
