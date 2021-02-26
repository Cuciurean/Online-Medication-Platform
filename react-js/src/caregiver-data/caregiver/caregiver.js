import React from 'react';
import {Card, Col, Row} from 'reactstrap';
import Table from "../../commons/tables/table"
import CaregiverForm from "./caregiver-form";

import * as API_USERS from "./api/caregiver-api";
import validate from "./validators/caregiver-validators";
import axios from "axios";




const filters = [
    {
        accessor: 'name',
    },
    {
        accessor: 'birth',
    },
    {
        accessor: 'gender',
    },
    {
        accessor: 'address',
    },
    {
        accessor: 'patients',
    },

    {
        accessor: '',
    },



];

class Caregiver extends React.Component {

    constructor(props){
        super(props);
        this.toggleForm = this.toggleForm.bind(this);
        this.state = {
            collapseForm: true,
            loadPage: false,
            errorStatus: 0,
            error: null,
            caregiver:[]
        };

        this.tableData = [];
    }

    toggleForm() {
        this.setState({collapseForm: !this.state.collapseForm});
    }

    componentDidMount() {
        this.fetchCaregiver();
    }

    fetchCaregiver() {
        return API_USERS.getCaregiver((result, status, err) => {
            console.log(result);
           if(result !== null && status === 200) {
               result.forEach( x => {
                   this.tableData.push({
                       name: x.name,
                       birth: x.birth,
                       gender: x.gender,
                       address: x.address,
                       patients: x.patients,
                       caregiver: x.id,

                   });
               });
               this.forceUpdate();
           } else {
               console.log("Am prins o eroare!!!");
               this.state.errorStatus = status;
               this.state.error = err;
               this.forceUpdate();
           }
        });
    }

    refresh(){
        this.forceUpdate()
    }
    deleteDep(caregiverId)
    {
        if(window.confirm('Are you sure'))
        {
            return axios.delete(`http://localhost:8080/caregiver/delete/${caregiverId}`,
            );
        }
        this.refresh()
    }

    render() {
        let pageSize = 5;

        return (

            <div>

                <Row>
                    <Col>
                        <Card body>
                            <Table
                                data={this.tableData}

                                columns={ [
                                    {
                                        Header:  'Name',
                                        accessor: 'name',
                                    },
                                    {
                                        Header: 'Birth',
                                        accessor: 'birth',
                                    },
                                    {
                                        Header: 'Gender',
                                        accessor: 'gender',
                                    },
                                    {
                                        Header: 'Address',
                                        accessor: 'address',
                                    },
                                    {
                                        Header: 'Patients',
                                        accessor: 'patients',
                                    },
                                    {
                                        Header: "Delete",
                                        Cell: row => (
                                            <div>
                                                <button className="mr-2" onClick={()=> this.deleteDep(row.original.caregiver)}
                                                        variant="danger"
                                                >Delete</button>

                                            </div>
                                        )

                                    },
                                ]
                                }
                                search={filters}
                                pageSize={pageSize}
                            />
                        </Card>
                    </Col>

                </Row>

                <Row>
                    <Col>
                        <Card body>
                            <div>
                                <CaregiverForm registerCaregiver={this.refresh}>


                                </CaregiverForm>

                            </div>
                        </Card>
                    </Col>
                </Row>
            </div>
        );
    };

}

export default Caregiver;
