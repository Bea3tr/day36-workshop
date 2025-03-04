import Dexie, { Table } from 'dexie';
import { City } from '../model/city';

export class AppDB extends Dexie {
    cities!: Table<City, number>

    constructor() {
        super('AppDB')
        this.version(1).stores({
            cities: '++id, code, city_name'
        })
    }

    async addCity(item: City) {
        const cityListId = await this.cities.add(item)
        console.log(`City added with id: ${cityListId}`)
    }

}

export const db = new AppDB()