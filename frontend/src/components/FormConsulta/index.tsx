import React, { useState } from 'react';
import { Button, Col, Form, Row, Table } from 'react-bootstrap';
import api from '../../services/api';

interface IAnnouncement {
  id: number;
  value: number;
  views: number;
  clicks: number;
  shares: number;
}

const FormConsulta: React.FC = () => {
  const [announcements, setAnnouncements] = useState<IAnnouncement[]>([]);

  async function search() {
    const results = await api.get(`/api/v1/announcements/`);
    setAnnouncements(results.data);
  }

  return (
    <>
      <Form className="mt-5">
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
          <Col xs={2}>
            <Form.Group>
              <Button variant="success" type="button" onClick={search}>
                Consultar relatório
              </Button>
            </Form.Group>
          </Col>
        </Row>
      </Form>

      <Table striped bordered hover className="text-center mt-5" size="sm">
        <thead>
          <tr>
            <th>#</th>
            <th>Valor total investido</th>
            <th>Quantidade máxima de visualizações</th>
            <th>Quantidade máxima de cliques</th>
            <th>quantidade máxima de compartilhamentos</th>
          </tr>
        </thead>
        <tbody>
          {announcements.map((ads) => (
            <tr key={ads.id}>
              <td>{ads.id}</td>
              <td>{ads.value}</td>
              <td>{ads.views}</td>
              <td>{ads.clicks}</td>
              <td>{ads.shares}</td>
            </tr>
          ))}
        </tbody>
      </Table>
    </>
  );
};

export default FormConsulta;
