# Universidad Latina de Panamá - Proyecto Final de Programación II
## Nombre del Proyecto
Sistema de Gestión Comercial para Empresa de Motores Industriales

## Integrantes
- Ana Freitez
- Cristell Cedeño
- Daniel Saldaña
- Eric Arce
- Luis Aguilar

## Descripción del Proyecto
Sistema desarrollado en Java para gestionar clientes, inventario, ventas, pagos y alertas de una empresa que vende motores industriales.

## Funciones
- Gestión de clientes
- Gestión de inventario
- Ventas y facturación
- Cuentas por cobrar
- Alertas y reportes

## Flujo del programa
### Inicio
Main llama a MenuPrincipal

### Funciones
#### Clientes
1. Ver clientes
- Se leen desde clientes.csv
2. Agregar cliente
- Se usa Scanner, se crea un objeto Cliente y se guarda en clientes.csv

#### Inventario
3. Ver inventario
- Se leen motores desde inventario.csv
4. Agregar motor
- Se usa Scanner, se crea un objeto Motor y se guarda en inventario.csv

#### Ventas
5. Registrar venta
- Se selecciona el cliente
- Se selecciona el motor
- Se ingresa la cantidad
- Se calcula el total
- Se descuenta del inventario
- Se guarda en ventas.csv
- Si el cliente no paga completo, se actualiza el saldo del cliente

#### Alertas
6. Ver alertas
- Alerta de stock bajo
- Alerta de clientes con saldo pendiente

7. Enviar una alerta
- Por ahora se simula en consola
