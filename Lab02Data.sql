INSERT INTO `Carrera` (`id`, `nombre`) VALUES
(501, 'Ingenieria de materiales'),
(504, 'Ingenieria de sistemas'),
(507, 'Ingenieria electrica'),
(510, 'Ingenieria electronica'),
(513, 'Ingenieria industrial'),
(516, 'Ingenieria mecanica'),
(522, 'Ingenieria quimica'),
(525, 'Ingenieria sanitaria'),
(527, 'Bioingenieria'),
(531, 'Ingenieria ambiental'),
(533, 'Ingenieria civil'),
(539, 'Ingenieria de telecomunicaciones'),
(540, 'Ingenieria oceanografica');

--
-- Dumping data for table `Estudiante`
--

INSERT INTO `Estudiante` (`documento`, `nombre`, `apellido`, `carrera`) VALUES
('1017233762', 'Frank Alexis ', 'Castrillon Giraldo', 540),
('1026154938', 'Santiago', 'Romero Restrepo', 525),
('1037562741', 'Pepe', 'Perez', 522),
('1037975885', 'Yoiner Esteban', 'Gomez Ayala', 522),
('1040046921', 'Jhonatan Alexander', 'Orozco Blandon', 507),
('1152454724', 'Maria Camila', 'Gomez Restrepo', 513);

--
-- Dumping data for table `Estudiante_Materia`
--

INSERT INTO `Estudiante_Materia` (`estudiante`, `materia`) VALUES
('1037562741', 464),
('1037562741', 513),
('1017233762', 553),
('1152454724', 553),
('1037975885', 561),
('1152454724', 561),
('1040046921', 584),
('1037562741', 740),
('1037562741', 750),
('1040046921', 750),
('1017233762', 760),
('1037562741', 760),
('1026154938', 770),
('1026154938', 780);

--
-- Dumping data for table `Materia`
--

INSERT INTO `Materia` (`codigo`, `nombre`, `cupo`, `horario`) VALUES
(110, ' SMN DE INGENIERIA SANIT', 19, ' L8-10'),
(464, ' SISTEMAS DE  ALCANTARIL', 21, ' M10-12'),
(513, ' CONTAMINACION ATMOSFERI', 19, ' WV8-10'),
(523, ' ESTRUCTURAS HIDRAULICAS', 19, ' LS8-10'),
(553, ' DESECHOS SOLIDOS', 19, ' MJ6-8'),
(561, ' SEMESTRE DE INDUSTRIA', 10, ' '),
(584, ' CONSTRUCCION', 19, ' WV18-20'),
(650, ' INTROD A LA ING SANITAR', 19, ' L8-10'),
(700, ' QUIMICA DEL AGUA', 20, ' LWV8-10'),
(720, ' MICROBIOLOGIA SANITARIA', 20, ' M16-18 J16-19'),
(730, ' SISTEMAS D ABASTECIM AG', 19, ' MJ14-16'),
(740, ' SISTEMAS DE ALCANTARILL', 21, ' M10-12'),
(750, ' PROCESOS FISICOQUIMICOS', 20, ' W8-10 V7-10'),
(760, ' PROCESOS BIOLOGICOS', 20, ' W14-16 V14-17'),
(770, ' SISTEMAS D POTABILIZACI', 21, ' WV6-8'),
(780, ' MANEJO D RESIDUOS SOLID', 19, ' MJ6-8');
