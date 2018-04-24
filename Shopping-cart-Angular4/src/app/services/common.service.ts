import { Observable,Subject } from 'rxjs'


export class CommonService {
 
    currentCart: Subject<any>=new Subject<any>();

 setCurrentCart(acc:any):void{
     this.currentCart.next(acc);
     this.currentCart=acc;
 }
getCurrentCart():Observable<any>{
    return this.currentCart.asObservable();
 }
 
}


