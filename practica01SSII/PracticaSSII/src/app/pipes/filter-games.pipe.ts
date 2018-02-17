import { Pipe, PipeTransform } from '@angular/core';
import { Card } from '../objects/card';

@Pipe({
  name: 'filterGames'
})
export class FilterGamesPipe implements PipeTransform {

  transform(items: any[], filter: String): any {
    if (!items || !filter) {
        return items;
    }
    // filter items array, items which match and return true will be
    // kept, false will be filtered out
    return items.filter(item => item.title.toLowerCase().indexOf(filter.toLowerCase()) !== -1);
}

}
