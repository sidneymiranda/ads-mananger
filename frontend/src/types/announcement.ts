import { Client } from './client';

export type Announcement = {
  adName: string;
  client: Client;
  startDate: string;
  endDate: string;
  investedTotal: number;
};
