# SmartClean · panel local en tiempo real

## 1. Preparar la red
- La PC y el ESP32 deben estar en la misma red Wi-Fi: `SSD BASURA/WIFI`.
- La red debe ser 2.4 GHz para el ESP32.
- Si el router tiene "aislamiento de clientes" o "AP isolation", desactívalo para que la PC pueda consultar al ESP32.

## 2. Encender el ESP32
- Al arrancar se conecta solo a `SSD BASURA/WIFI`.
- La pantalla LCD muestra la IP asignada, por ejemplo `192.168.1.50`.
- También puedes verla en el Monitor Serie a 115200 baudios.
- Dirección de datos: `http://IP-DEL-ESP32/datos`
- Alternativa con mDNS: `http://smartclean.local/datos`

## 3. Abrir el panel en esta PC
- Haz doble clic en `iniciar_panel.bat`.
- Se abre: `http://localhost:8000/SmartClean_Construccion_Realista.html`
- La página intenta conectarse sola a `http://smartclean.local/datos`.
- Si no conecta, escribe la IP que muestra la LCD, por ejemplo:
  `http://192.168.1.50/datos`
- Pulsa **Conectar**. La dirección queda guardada en el navegador.

## 4. Abrir el panel desde otra PC de la misma Wi-Fi
- Ejecuta `iniciar_panel.bat` en la PC que servirá la página.
- En la otra PC abre la dirección que muestra la ventana, por ejemplo:
  `http://192.168.1.20:8000/SmartClean_Construccion_Realista.html`
- Si no carga, permite el puerto 8000 en el Firewall de Windows de la PC servidora.

## 5. Qué muestra el panel
- Radar circular con la ocupación interna del tacho y porcentaje.
- Nivel, distancia real y estado lleno/vacío.
- Tapa abierta o cerrada y sensor de proximidad.
- Contador de aperturas guardado en el ESP32.
- Estado del MQ-4, lectura digital y alerta de gas.
- Tiempo encendido, señal Wi-Fi, IP y red del ESP32.
- Botones de sonido: prueba, doble pitido, intermitente, continuo, La Cucaracha, retro, funk y silenciar.
- Registro de eventos.

## 6. Comandos de sonido
- La página envía `GET /sonido?p=prueba`, `doble`, `intermitente`, `continuo`, `cucaracha`, `retro`, `funk` o `silencio`.
- Si el buzzer apenas suena, usa **Probar modo activo** y **Probar modo pasivo**. El modo que suene más fuerte queda guardado en el ESP32.
- El modo pasivo usa un tono de 2700 Hz; el modo activo mantiene la señal en alto.
- Silenciar detiene la alarma automática hasta que desaparezca la causa.

## 7. Notas
- El panel no usa clima, mapa, GPS, panel solar ni luces: muestra solo los datos del prototipo.
- Si un objeto queda muy cerca del sensor de nivel y no hay eco, tras 3 lecturas el firmware lo interpreta como 100%.
- El ESP32 y el panel funcionan en la red local aunque no haya internet.
- El ESP32 no se publica en internet; solo es accesible desde la misma red.
- La copia del firmware original está en `backup\BoteBasura15cm_Portal.ino.bak`.
