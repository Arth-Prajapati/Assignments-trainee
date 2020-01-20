function product()
{
    let files = document.getElementById('pimg').files;
    let pname = document.forms['form']['pname'].value;
    let pdescription = document.forms['form']['pdescription'].value;
    let pquantity = document.forms['form']['pquantity'].value;
    let pprice = document.forms['form']['price'].value;

    Addproduct(files,pquantity,pdescription, pname,pprice);

}

let qu=pquantity;





function Addproduct( files,pquantity,pdescription,pname,pprice)
{

    
    
    if (files && files.length) 
    {
        var fr = new FileReader();
    
        fr.onload = function () 
        {
    
            var div = document.createElement('div'); 
            var img = document.createElement('img');
            img.style.height="200px";
            img.style.width="300px"; 
            var h4 = document.createElement('h4');
            var p1 = document.createElement('p');
            var p2 = document.createElement('p');
            var p3 = document.createElement('p');
            var btn = document.createElement('button'); 

            btn.innerHTML="Add to cart";

            img.src = fr.result;
    
            img.classList.add("img-thumbnail");

            h4.innerHTML = pname;
            p1.innerHTML = pdescription;
            p2.innerHTML = pquantity;
            p3.innerHTML = pprice;
            
    
           
    
            div.appendChild(img);  
            div.appendChild(h4);
            div.appendChild(p1);
            div.appendChild(p2);
            div.appendChild(p3);  
            div.appendChild(btn);

            document.getElementById('display').appendChild(div);
            
            var name= document.forms['form']['pname'].value;
            var quant = document.forms['form']['pquantity'].value;
            var price = document.forms['form']['price'].value;
            parseInt(quant,10);
            parseInt(price,10);
           
            btn.onclick = function() 
            {
                var q=prompt("Enter Quantity","");
                parseInt(q,10);
                if(q<quant)
                {   div.removeChild(img);  
                    div.removeChild(h4);
                    div.removeChild(p1);
                    div.removeChild(p2);
                    div.removeChild(p3);  
                    div.removeChild(btn);
                    let remainq = quant - q;
                    Addproduct(files,remainq,pdescription,pname,price);
                    addtocart(files,q,pdescription,name,price)}
                else if(q==quant){ 
                        div.removeChild(img);  
                        div.removeChild(h4);
                        div.removeChild(p1);
                        div.removeChild(p2);
                        div.removeChild(p3);  
                        div.removeChild(btn);
                        addtocart(q,name,price)
            }
                else{alert("we have" + quantity + "items");}
            };
    
            
             
        }
        
        fr.readAsDataURL(files[0]);
    }

}

function addtocart(files,quantity,pdescription, productname,productprice)
{
    if (files && files.length) 
    {
        var fr = new FileReader();
    
        fr.onload = function () 
        {
    
      
                
                var div = document.createElement('div'); 
                var img = document.createElement('img');
                img.style.height="20px";
                img.style.width="30px";
                var h5=document.createElement('h5');
                var h6=document.createElement('h6');   
                var p=document.createElement('p');
                var btn = document.createElement('button'); 
                btn.innerHTML="Delete from cart";

                img.src = fr.result;
                
                        img.classList.add("img-thumbnail");


                
                    h5.innerHTML=productname;
                    h6.innerHTML=quantity;
                    var pr=quantity * productprice;
                    p.innerHTML= pr;
                div.appendChild(h5);
                div.appendChild(h6);
                div.appendChild(p);
                div.appendChild(btn);


                document.getElementById('cart').appendChild(div);
                btn.onclick = function() 
                {
                    var d=prompt("enter quantity to delete","");
                    parseInt(d,10);
                    if(d < quantity){
                        div.removeChild(h5);
                        div.removeChild(h6);
                        div.removeChild(p);
                        div.removeChild(btn);
                        d=quantity-d;
                        quantity=qu+d;
                        Addproduct(files,quantity,pdescription, productname,productprice);
                        addtocart(files,d,pdescription, productname,productprice);
                    }else if(d==q){
                        div.removeChild(h5);
                        div.removeChild(h6);
                        div.removeChild(p);
                        div.removeChild(btn);

                    }
                    else{
                        alert("you have" + d +"quantity in cart");
                    }
                
                
                };
        
        }
        fr.readAsDataURL(files[0]);
    }

}   
  


  



    

   
