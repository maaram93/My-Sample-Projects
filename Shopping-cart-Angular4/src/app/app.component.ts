import { Component ,OnInit} from "@angular/core";
import{CommonService} from 'app/services/common.service'
@Component({
  selector: "app-root",
  template: "<router-outlet></router-outlet>"
})
export class AppComponent implements OnInit {
  constructor(private commonService:CommonService){}
  ngOnInit(){
  
  }
}
