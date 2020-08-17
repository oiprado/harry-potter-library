import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomePage } from './pages/home/home.page';
import { ShoppingCartPage } from './pages/shopping-cart/shopping-cart.page';


const routes: Routes = [
  { path: "home", component: HomePage },
  { path: "shopping-cart", component: ShoppingCartPage },
  { path: '', redirectTo: 'home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
