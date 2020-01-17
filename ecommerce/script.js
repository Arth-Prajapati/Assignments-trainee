function Addproduct(){

    let files = document.getElementById('pimg').files;
    
    if (files && files.length) {
        var fr = new FileReader();
    
        fr.onload = function () {
    
            var div = document.createElement('div'); 
            var img = document.createElement('img');
            img.style.height="200px";
            img.style.width="300px"; 
            var h4 = document.createElement('h4');
            var p1 = document.createElement('p');
            var p2 = document.createElement('p');
            var btn = document.createElement('button'); 

            btn.innerHTML="Add to cart";

            img.src = fr.result;
    
            img.classList.add("img-thumbnail");
    
            h4.innerHTML = document.forms['form']['pname'].value;
            p1.innerHTML = document.forms['form']['pdescription'].value;
            p2.innerHTML = document.forms['form']['pquantity'].value;
    
            div.appendChild(img);  
            div.appendChild(h4);
            div.appendChild(p1);
            div.appendChild(p2);  
            div.appendChild(btn);

            document.getElementById('display').appendChild(div); 

            btn.onclick = function() {addtocart(p2,h4)};
    
            
             
        }
        
        fr.readAsDataURL(files[0]);
    }

  }

  function addtocart( quantity, name){
      var q=prompt("Enter Quantity","");1
      if(q<quantity)
      {alert("");}
      else{alert("we have" + quantity + "items");}
  }


  



    

   
