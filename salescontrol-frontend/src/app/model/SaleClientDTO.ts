import { Client } from './client';
import { ProductDTO } from './ProductDTO';

export class SaleClientDTO{
    client:Client;
    products:ProductDTO[];
}