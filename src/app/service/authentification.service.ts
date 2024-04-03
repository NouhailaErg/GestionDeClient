import { Injectable } from '@angular/core';
import { ObjectUnsubscribedError, Observable, of, throwError } from 'rxjs';
import { AppUser } from '../dto/user';

@Injectable({
  providedIn: 'root'
})
export class AuthentificationService {

  users : AppUser[]=[];
  authenticatedUser : AppUser | undefined;
  constructor() { 
    this.users.push({userId :"",username : "user1", password :"1234", role :["USER"]});
  }
  public login(username : string , password: string):Observable<AppUser>{
  let appUser =  this.users.find(u => u.username);
  if(!appUser) return throwError(()=> new Error("User not Found"));
  if(appUser.password!=password){
    return throwError(()=> new Error("Password is False"));
  }
  return of(appUser);
  }
  public authenticateUser(appUser : AppUser):Observable<boolean>{
    this.authenticatedUser = appUser;
    localStorage.setItem("authUser", JSON.stringify({username : appUser.username, role : appUser.role, jwt :"JWT_TOKEN"}));
  return of (true);
  }
  public hasRole(role : string) : boolean{
  return this.authenticatedUser!.role.includes(role);
  }
  public isAuth(){
    return this.authenticatedUser!=undefined;
  }
}
