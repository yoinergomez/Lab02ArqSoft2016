--
-- Database: Lab02 
--

-- --------------------------------------------------------

--
-- Table structure for table Carrera 
--

CREATE TABLE IF NOT EXISTS Carrera (
  id int(11) NOT NULL AUTO_INCREMENT,
  nombre varchar(50) NOT NULL,
 PRIMARY KEY ( id )
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table Estudiante 
--

CREATE TABLE IF NOT EXISTS Estudiante (
  documento varchar(10) NOT NULL,
  nombre varchar(50) NOT NULL,
  apellido varchar(50) NOT NULL,
  carrera int(11) NOT NULL,
 PRIMARY KEY ( documento ),
 KEY carrera ( carrera )
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table Estudiante_Materia 
--

CREATE TABLE IF NOT EXISTS Estudiante_Materia (
  estudiante varchar(10) NOT NULL,
  materia int(11) NOT NULL,
 PRIMARY KEY ( estudiante , materia ),
 KEY Estudiante_Materia_ibfk_2 ( materia )
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table Materia 
--

CREATE TABLE IF NOT EXISTS Materia (
  codigo int(11) NOT NULL AUTO_INCREMENT,
  nombre varchar(50) NOT NULL,
  cupo int(11) NOT NULL,
  horario varchar(50),
 PRIMARY KEY ( codigo )
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Constraints for dumped tables
--

--
-- Constraints for table Estudiante 
--
ALTER TABLE Estudiante 
 ADD CONSTRAINT Estudiante_ibfk_1 FOREIGN KEY ( carrera ) REFERENCES Carrera ( id ) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table Estudiante_Materia 
--
ALTER TABLE Estudiante_Materia 
 ADD CONSTRAINT Estudiante_Materia_ibfk_2 FOREIGN KEY ( materia ) REFERENCES Materia ( codigo ) ON DELETE CASCADE ON UPDATE CASCADE,
 ADD CONSTRAINT Estudiante_Materia_ibfk_1 FOREIGN KEY ( estudiante ) REFERENCES Estudiante ( documento ) ON DELETE CASCADE ON UPDATE CASCADE;
