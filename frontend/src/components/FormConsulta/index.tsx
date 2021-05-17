import React, { useState, useEffect } from 'react';
import { Button, Col, Form, Row, Table } from 'react-bootstrap';
import { MdAttachMoney } from 'react-icons/md';
import { FaShareAlt } from 'react-icons/fa';
import { GiClick } from 'react-icons/gi';
import { BiCheckDouble } from 'react-icons/bi';
import api from '../../services/api';

interface IAnnouncement {
  id: number;
  investedTotal: number;
  views: number;
  clicks: number;
  shares: number;
}

const FormConsulta: React.FC = () => {
  const [announcements, setAnnouncements] = useState<IAnnouncement[]>([]);

  async function load() {
    const results = await api.get(`/reports`);
    setAnnouncements(results.data);
  }

  useEffect(() => {
    load();
  }, []);

  return (
    <>
      <Form className="container mt-5">
        <Row>
          <Col xs={6}>
            <Form.Group as={Row}>
              <Form.Control
                type="text"
                placeholder="Insira o nome do cliente a ser consultado"
              />
              <Form.Text className="text-muted">
                Busca por nome do cliente
              </Form.Text>
            </Form.Group>
          </Col>
          <Col xs={2}>
            <Form.Group>
              <Form.Control type="date" />
            </Form.Group>
            <Form.Text className="text-muted">Busca por período</Form.Text>
          </Col>
          <Col xs={1}>
            <Form.Group>
              <Button variant="success" type="button">
                Consultar relatório
              </Button>
            </Form.Group>
          </Col>
        </Row>
      </Form>

      <Table
        responsive
        striped
        bordered
        hover
        className="text-center mt-5"
        size="md"
      >
        <thead>
          <tr>
            <th>#</th>
            <th>
              <MdAttachMoney /> Investimento
            </th>
            <th>
              <BiCheckDouble /> Visualizações
            </th>
            <th>
              <GiClick /> Cliques
            </th>
            <th>
              <FaShareAlt /> Compartilhamentos
            </th>
          </tr>
        </thead>
        <tbody>
          {announcements.map((ad) => (
            <tr key={ad.id}>
              <td>{ad.id}</td>
              <td>{ad.investedTotal}</td>
              <td>{ad.views}</td>
              <td>{ad.clicks}</td>
              <td>{ad.shares}</td>
            </tr>
          ))}
        </tbody>
      </Table>
    </>
  );
};

export default FormConsulta;
