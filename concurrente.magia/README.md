🔐 Ministerio de Magia - Backend de Gestión de Hechizos y Eventos

Participantes: Jacob Altenburger Villar, Pablo Barbosa Ojeda, Assil, Augusto Perrone, Pedro Velasco

Link al repositorio: https://github.com/jacobgalactico/concurrente.magia

Este repositorio contiene el backend del sistema avanzado de gestión de hechizos y eventos mágicos para el Ministerio de Magia. Está desarrollado con Spring Boot y es responsable de gestionar la autenticación, el control de acceso, el procesamiento concurrente de datos y las notificaciones en tiempo real.
📋 Descripción

El sistema de gestión del Ministerio de Magia está diseñado para manejar grandes volúmenes de datos en tiempo real, provenientes de eventos mágicos registrados en todo el reino. Estos datos incluyen hechizos, autorizaciones y accesos controlados. El backend procesa estos datos de manera concurrente, garantizando respuestas rápidas en situaciones críticas.

Además, el backend implementa autenticación y autorización mediante Spring Security y utiliza JWT para gestionar el acceso de los usuarios. En caso de alertas mágicas, se envían notificaciones en tiempo real utilizando WebSocket y servicios de mensajería.
🏗️ Arquitectura General

El backend es el núcleo del sistema, encargado de procesar y gestionar todos los eventos generados. La arquitectura incluye:

    Spring Boot: Framework principal del backend.
    Spring Security con JWT: Manejo de autenticación y autorización.
    @Async y ExecutorService: Para manejar la concurrencia en el procesamiento de datos.
    WebSocket: Para enviar notificaciones en tiempo real a los usuarios.
    PostgreSQL: Base de datos para almacenar los eventos y la información mágica.
    Spring Actuator: Para la monitorización del sistema.