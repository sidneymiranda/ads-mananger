import { Client } from './client';

export type Announcement = {
  nomeDoAnuncio: string;
  cliente: Client;
  dataDeInicio: string;
  dataDeTermino: string;
  InvestimentoPorDia: number;
};
