import React from 'react';
import {Card, Col, Row} from 'reactstrap';
import Table from "../../commons/tables/table"
import PatientForm from "./patient-form";
import axios from 'axios'

import * as API_USERS from "./api/patient-api";
import {postPatient} from "./api/patient-api";
import {useRows} from "react-table/lib/hooks/useRows";

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
        accessor: 'record',
    },

    {
        accessor: '',
    },



];

class Patient extends React.Component {

    constructor(props){
        super(props);
        this.toggleForm = this.toggleForm.bind(this);
        this.state = {
            collapseForm: true,
            loadPage: false,
            errorStatus: 0,
            error: null,
            patient: []
        };

        this.tableData = [];

        this.deleteDep = this.deleteDep.bind(this);
    }

    toggleForm() {
        this.setState({collapseForm: !this.state.collapseForm});
    }

    componentDidMount() {
        this.fetchPatient();
    }

    fetchPatient() {
        return API_USERS.getPatient((result, status, err) => {
            console.log(result);
           if(result !== null && status === 200) {
               this.setState({patients: result.data})
               result.forEach( x => {
                   this.tableData.push({
                       name: x.name,
                       birth: x.birth,
                       gender: x.gender,
                       address: x.address,
                       record: x.record,
                       patient: x.id
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

    refresh() {
        this.forceUpdate()
    }

    deleteDep(patientId)
    {
        if(window.confirm('Are you sure'))
        {
            return axios.delete(`http://localhost:8080/patient/delete/${patientId}`,
            );
        }
       this.refresh()
    }


    render() {

        let addModalClose =() => this.setState({addModalShow:false});
        let editModalClose =() => this.setState({editModalShow:false});
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
                                    Header: 'Record',
                                    accessor: 'record',
                                    },
                                    {
                                    Header: "Delete",
                                    Cell: row => (
                                    <div>
                                        <button className="mr-2" onClick={()=> this.deleteDep(row.original.patient)}
                                                variant="danger"
                                        >Delete</button>
                                        <button className="mr-2"  variant="info" onClick={()=> this.setState({editModalShow:true, patientId:row.original.patient})}
                                        >Edit</button>



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
                                <PatientForm registerPatient={this.refresh}>
                                </PatientForm>
                                    <PatientForm deleteDep={this.refresh}>

                                </PatientForm>

                            </div>
                        </Card>
                    </Col>
                </Row>
            </div>
        );
    };

}

export default Patient;
