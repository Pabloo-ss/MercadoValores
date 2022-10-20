# Mercado de valores

## Introducción
Este proyecto ha sido realizado para aprender de forma didáctica como desarrollar una aplicación Java que use conexiones a bases de datos, en este caso a través de JDBC. En el desarrollo de dicha aplicación ha sido realizado polo seguinte equipo: [Nicolás Vilela Pérez](https://github.com/nicovp10), [Adrián Vidal Lorenzo](https://github.com/adrianvidal2), otras 3 persoas y Pablo Souto Soneira.

La aplicación reproduce un mercado de valores en el que se pueden realizar diferentes acciones y en el que existen diferentes tipos de usuarios.

El repositorio está formado por un directorio con los scripts relacionados con la BBDD (`scriptsBBDD`), el código de la aplicación (`src`), el fichero de configuración de la conexión a la BBDD (`baseDatos.properties`), la librería necesaria para la conexión a una BBDD de PostgreSQL (`postgresql.jar`) y una librería para visualizar calendarios en la interfaz gráfica (`jcalendar-1.4.jar`).


## Objetivo del proyecto
El sistema debe permitir que diferentes empresas puedan ofrecer participaciones sobre sus beneficios comerciales futuros. También debe permitir que diferentes inversores puedan adquirir las participaciones de las empresas participantes (las empresas también pueden adquirir participaciones de otras empresas). El mercado de valores contará con un regulador que autorizará, verificando diversas condiciones, la participación en el mercado de valores de empresas e inversores.

En este mercado de valores se podrán negociar (compra y venta) las participaciones de las empresas registradas. Además, cada empresa podrá pagar beneficios comerciales, previamente anunciados, a sus inversores.


## Funcionalidades del sistema
A continuación se presentan detalladamente los tipos de usuario que existen en el sistema así como todas las funcionalidades que tiene el mismo, divididas en funcionalidades de usuarios (FU) y funcionalidades de comercio (FC).

### Tipos de usuarios
* __Regulador:__ usuario encargado de verificar el funcionamiento correcto del mercado de valores, especialmente en lo referido a la gestión de las cuentas de las empresas e inversores (modificaciones manuales de los saldos de las cuentas) y establecimiento de la comisión de compra/venta. No es necesario ningún dato de identificación personal ya que se trata de una persona jurídica. Accederá al sistema mediante identificación usuario/password.

* __Empresas:__ organizaciones que desean ofrecer participaciones sobre sus beneficios comerciales futuros. Se necesitan los siguientes datos de identificación: CIF, nombre comercial, dirección y teléfono de contacto. Podrá realizar acciones de compra/venta sobre las participaciones de las empresas autorizadas en el sistema (propias o ajenas). Accederá al sistema mediante identificación usuario/password.

* __Inversores:__ personas físicas que desean invertir mediante la negociación con participaciones de empresas. Se necesitan los siguientes datos de identificación: DNI, nombre y apellidos, dirección y teléfono de contacto. Podrá realizar acciones de compra/venta sobre las participaciones de las empresas autorizadas en el sistema. Accederá al sistema mediante identificación usuario/password.


### Funcionalidades de usuarios
* __[FU_01] Acceso al sistema:__ el sistema solicitará a los usuarios su identificador y su clave de acceso. Si la información suministrada es correcta se accederá a la información de usuario y este podrá realizar las operaciones asociadas a su tipo de usuario. En caso contrario, se informará de un error en las credenciales.

* __[FU_02] Solicitud de registro:__ cualquier empresa/inversor podrá solicitar el alta en el mercado de valores mediante el suministro de sus datos de identificación. En este proceso de solicitud de registro, el usuario propondrá un identificador y una clave de acceso. En el caso de que el identificador ya exista en el sistema se informará al usuario y se volverá a solicitar. Si todos los datos son correctos se registrará la solicitud. Quedará pendiente de confirmar por parte del regulador.

* __[FU_03] Confirmación de registro:__ una solicitud de registro se convertirá en un registro efectivo cuando el regulador lo autorice. Una vez confirmado el registro, el usuario podrá acceder a una cuenta dónde se almacenarán sus fondos disponibles y a una cartera de participaciones dónde se almacenarán las participaciones que posee de cada empresa.

* __[FU_04] Modificación de datos:__ cualquier empresa/inversor podrá modificar sus datos de identificación en cualquier momento. También podrá modificar su identificador (siempre que siga siendo único en el sistema) y su clave de acceso. En el caso de que el identificador propuesto ya exista en el sistema se informará de un error en la modificación de datos.

* __[FU_05] Modificación de saldo de cuenta:__ las modificaciones en el saldo de las cuentas de los usuarios, consecuencia de transferencias económicas recibidas y/o emitidas por la administración del mercado de valores, serán realizadas por el regulador tras la comprobación de la correspondiente transferencia (en la base de datos no se almacenará ninguna información sobre dichas transferencias). Los usuarios no podrán realizar modificaciones manuales en los saldos de sus cuentas (las modificaciones serán consecuencia de la realización de operaciones).

* __[FU_06] Solicitud de baja:__ cualquier empresa/inversor podrá solicitar su baja en el sistema en cualquier momento. Quedará pendiente de confirmar por parte del regulador.

* __[FU_07] Confirmación de baja:__ la baja de un usuario debe ser confirmada por el regulador, una vez verifique que el usuario no posee participaciones y que el saldo de su cuenta está a cero. En el caso de que el usuario tenga participaciones se rechazará la baja. En el caso de que el saldo no sea cero se pondrá a cero (suponiendo la realización de la correspondiente transferencia) y se tramitará la baja.


## Funcionalidades de comercio
* __[FC_01] Alta de participaciones:__ las empresas registradas podrán dar de alta el número de participaciones que deseen. Las participaciones dadas de alta por una empresa se incorporaran a su propia cartera de participaciones. Por simplicidad del sistema, las participaciones no se identificaran de forma unitaria. Sólo se registrará la cantidad total de participaciones, de cada empresa, que posee cada empresa/inversor y el número total de participaciones involucradas en cada operación de compra/venta.

* __[FC_02] Baja de participaciones:__ las empresas registradas podrán dar de baja el número de participaciones que deseen, siempre y cuando dispongan de ellas en su propia cartera. Las participaciones dadas de baja por una empresa se eliminarán del sistema disminuyendo el número total de participaciones existentes.

* __[FC_03] Comisión de compra/venta:__ el regulador del mercado fijara una comisión sobre las operaciones de compra/venta. El importe de la comisión de compra/venta deberá ser público y se informará al vendedor en el momento de realizar la oferta de venta. El importe de dicha comisión, a deducir del ingreso al vendedor, será ingresado en la cuenta especial del regulador. La comisión a aplicar a una operación de compra/venta será la disponible de forma pública en el sistema en el momento de poner en el mercado la oferta de venta.

* __[FC_04] Venta de participaciones:__ cualquier usuario, inversor y/o empresa, poseedor de participaciones de alguna empresa podrá ponerlas a la venta. El total de participaciones puestas a la venta por un usuario no puede ser superior al número de participaciones que posee dicho usuario. Para ello deberá indicar la empresa, el número global de participaciones y el precio de venta. Cuando las participaciones se vendan, recibirá en su cuenta el importe de la venta menos la comisión fijada por el mercado de valores. Las ofertas de venta permanecerán en el mercado de forma permanente salvo que sean retiradas por el usuario que las realizo.

* __[FC_05] Baja de venta de participaciones:__ el usuario que ha realizado una oferta de venta podrá eliminarla en cualquier momento. En el caso de ejecuciones parciales de la oferta de venta, la baja afectará a la parte de la oferta no ejecutada.

* __[FC_06] Compra de participaciones:__ cualquier usuario podrá realizar ofertas de compra, siempre y cuando disponga de saldo suficiente en su cuenta. Para ello deberá indicar la empresa, el número global de participaciones y el precio máximo de compra. La compra se realizará de forma completa si hay suficientes participaciones a la venta al precio indicado o inferior (una compra puede completarse a partir de varias ofertas de venta; en ese caso, se seleccionaran las ofertas de venta por orden de precio y de antigüedad) o de forma parcial si hay menos participaciones a la venta, al precio fijado o inferior, de las indicadas en la orden de compra. Las ordenes de compra no quedarán en el mercado una vez cruzadas con las ofertas de venta existentes, tanto se hayan realizado de forma parcial o, incluso, no se hayan podido realizar por no existir oferta adecuada.

* __[FC_07] Alta de pago de beneficios:__ las empresas registradas podrán publicar información sobre sus pagos futuros de beneficios asociados a  las participaciones que están en negociación en el mercado. Para ello deberá indicar la fecha de pago y el beneficio a abonar por cada participación (puede ser saldo en efectivo, participaciones o una combinación de ambas). Para completar el alta deberá tener en su cuenta el importe suficiente (en saldo en efectivo y/o en participaciones) para hacer frente al pago de beneficios a publicar. El importe de dicho pago se bloqueará (no estará disponible para operaciones) hasta la eliminación del anuncio de pago o hasta la realización del pago.

* __[FC_08] Baja de pago de beneficios:__ la eliminación de información sobre pagos de beneficios sólo podrá ser realizada por el regulador del mercado de valores a petición de la empresa que lo ha realizado (en la base de datos no se almacenará ninguna información sobre dichas peticiones de baja).

* __[FC_09] Pago de beneficios:__ las empresas podrán realizar pagos de beneficios asociados a participaciones en cualquier momento, con anuncio previo o sin anuncio previo. En el caso de anuncio previo, en el momento de realizar el pago se eliminará el anuncio asociado y se realizará el pago con los fondos (saldo y/o participaciones) previamente bloqueados. En el caso de que no exista anuncio previo, el pago se realizará directamente, si la empresa dispone de fondos suficientes en su cuenta.

* __[FC_10] Stacking:__ un usuario puede depositar parte de sus participaciones durante un periodo mínimo de tiempo generando intereses en base a su valor. El porcentaje de interés es estipulado por el regulador. Cada mes el usuario tiene la posibilidad durante un día de retirar esas acciones, en caso de que no lo haga seguirán generando durante otro mes. Puede activarse una opción para que se retiren automáticamente pasando ese tiempo.

* __[FC_11] Contratos de futuros:__ un contrato de futuros es un pacto según el cual en un momento dado se acuerda el precio de una compra o venta que se va a realizar dentro de un periodo de tiempo X. Este tipo de contratos se utilizan para favorecer la especulación de manera que se aprovecha la diferencia entre el precio pactado y el real en el momento X para generar beneficios o pérdidas.
