import React from 'react';
import validate from "./validators/patient-validators";
import TextInput from "./fields/TextInput";
import './fields/fields.css';
import Button from "react-bootstrap/Button";
import * as API_USERS from "./api/patient-api";
import {getPatient} from "./api/patient-api";



class PatientForm extends React.Component{

    constructor(props){
        super(props);
        this.toggleForm = this.toggleForm.bind(this);

        this.state = {

            errorStatus: 0,
            error: null,

            formIsValid: false,

           formControls : {

               name: {
                   value: '',
                   placeholder: '',
                   valid: false,
                   touched: false,

               },

               birth: {
                   value: '',
                   placeholder: '',
                   valid: false,
                   touched: false,
               },

               gender: {
                   value: '',
                   placeholder: '',
                   valid: false,
                   touched: false,

               },
               address: {
                   value: '',
                   placeholder: '',
                   valid: false,
                   touched: false,

               },
               record: {
                   value: '',
                   placeholder: '',
                   valid: false,
                   touched: false,

               },
           }
        };

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);

    }

    toggleForm() {
        this.setState({collapseForm: !this.state.collapseForm});
    }

    componentDidMount() {

    }


    handleChange = event => {

        const name = event.target.name;
        const value = event.target.value;

        const updatedControls = {
            ...this.state.formControls
        };

        const updatedFormElement = {
            ...updatedControls[name]
        };

        updatedFormElement.value = value;
        updatedFormElement.touched = true;
        updatedFormElement.valid = validate(value, updatedFormElement.validationRules);

        console.log("Element: " +  name + " validated: " + updatedFormElement.valid);

        updatedControls[name] = updatedFormElement;

        let formIsValid = true;
        for (let updatedFormElementName in updatedControls) {
            formIsValid = updatedControls[updatedFormElementName].valid && formIsValid;
        }

        this.setState({
            formControls: updatedControls,
            formIsValid: formIsValid
        });
    };

    registerPatient(patient){
        return API_USERS.postPatient(patient, (result, status, error) => {
            console.log(result);

            if(result !== null && (status === 200 || status ===201)){
                console.log("Successfully inserted patient with id: " + result);
                this.props.refresh();
            } else {
                this.state.errorStatus = status;
                this.error = error;
            }
        });
    }



    handleSubmit(){

        console.log("New patient data:");
        console.log("Name: " + this.state.formControls.name.value);
        console.log("Birth: " + this.state.formControls.birth.value);
        console.log("Gender: " + this.state.formControls.gender.value);
        console.log("Address: " + this.state.formControls.address.value);
        console.log("Record: " + this.state.formControls.record.value);

        let user = {
            name: this.state.formControls.name.value,
            birth : this.state.formControls.birth.value,
            gender: this.state.formControls.gender.value,
            address: this.state.formControls.address.value,
            record: this.state.formControls.record.value
        };

        this.registerPatient(user);
    }




    render() {
        return (

          <form onSubmit={this.handleSubmit}>

              <h1>Insert new patient</h1>

              <p> Name: </p>

              <TextInput name="name"
                         placeholder={this.state.formControls.name.placeholder}
                         value={this.state.formControls.name.value}
                         onChange={this.handleChange}
                         touched={this.state.formControls.name.touched}
                         valid={this.state.formControls.name.valid}
              />
              {this.state.formControls.name.touched && !this.state.formControls.name.valid &&
              <div className={"error-message row"}> * Name must have at least 3 characters </div>}

              <p> Birth: </p>
              <TextInput name="birth"
                         placeholder={this.state.formControls.birth.placeholder}
                         value={this.state.formControls.birth.value}
                         onChange={this.handleChange}
                         touched={this.state.formControls.birth.touched}
                         valid={this.state.formControls.birth.valid}
              />

              <p> Gender: </p>
              <TextInput name="gender"
                         placeholder={this.state.formControls.gender.placeholder}
                         value={this.state.formControls.gender.value}
                         onChange={this.handleChange}
                         touched={this.state.formControls.gender.touched}
                         valid={this.state.formControls.gender.valid}
              />

              <p> Address: </p>
              <TextInput name="address"
                         placeholder={this.state.formControls.address.placeholder}
                         value={this.state.formControls.address.value}
                         onChange={this.handleChange}
                         touched={this.state.formControls.address.touched}
                         valid={this.state.formControls.address.valid}
              />

              <p> Record: </p>
              <TextInput name="record"
                         placeholder={this.state.formControls.record.placeholder}
                         value={this.state.formControls.record.value}
                         onChange={this.handleChange}
                         touched={this.state.formControls.record.touched}
                         valid={this.state.formControls.record.valid}
              />


              <p></p>
              <Button variant="success"
                      type={"submit"}
                      disabled={!this.state.formIsValid}>
                  Submit
              </Button>


          </form>

        );
    }
}

export default PatientForm;
