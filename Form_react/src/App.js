import React from 'react';
import ReactDOM from 'react-dom';
import './App.css';

var namelist =[];
var contactlist =[];
var addresslist =[];

function App() {
  return(<Fields />);

   
}

function Rendertable(){

  var tablerow = [];
  for(var i=0;i<namelist.length;i++){
   
    tablerow.push(<tr>
                    <td>{namelist[i]}</td>
                    <td>{contactlist[i]}</td>
                    <td>{addresslist[i]}</td>
                  </tr>);


  }

 

return(<table><thead><tr>
        <th>NAME</th>
        <th>CONTACT</th>
        <th>ADDRESS</th></tr></thead><tbody>{tablerow}</tbody></table>)


}



class Fields extends React.Component{
  constructor(props){
    super(props);
    this.state={namevalue: '',addressvalue: '',contactvalue: ''};

    this.handleChange=this.handleChange.bind(this);
    this.handleSubmit=this.handleSubmit.bind(this);

  }

  handleChange(event){
    const value = event.target.value;
    this.setState({[event.target.name]: value});
  }

  handleSubmit(event){
     var name = this.state.namevalue;
     var address = this.state.addressvalue;
     var contact = this.state.contactvalue;
     
     event.preventDefault();
    
    namelist.push(name);
    addresslist.push(address);
    contactlist.push(contact);

   
    
    ReactDOM.render(<Rendertable namelist addresslist contactlist/>, document.getElementById('table'));
    

    
    
  }


  render() {
    return(
      <div>
      <form onSubmit={this.handleSubmit}>
        <label>Name:</label>
        <input type="text" name="namevalue" value={this.state.namevalue} onChange={this.handleChange}/>
        
        <br></br>
        <br></br>
        <label>address:</label>
        <input type="text" name="addressvalue" value={this.state.addressvalue} onChange={this.handleChange}/>
        
        <br></br>
        <br></br>
        <label>contact:</label>
        <input type="text" name="contactvalue" value={this.state.contactvalue} onChange={this.handleChange}/>
        
        <br></br>
        <br></br>

        
        <input type="submit" value="Submit" />
        
      </form>
       <div id="table">

       </div>
  
      </div>



    );

    
  }
}


export default App;
