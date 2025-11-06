package es.upm.grise.profundizacion.cruiseController;

import es.upm.grise.profundizacion.cruiseControl.CruiseControl;
import es.upm.grise.profundizacion.cruiseControl.Speedometer;
import es.upm.grise.profundizacion.exceptions.IncorrectSpeedSetException;
import es.upm.grise.profundizacion.exceptions.SpeedSetAboveSpeedLimitException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

class CruiseControlTest {

	@Test
	void speedSetTieneQueSerNuloAlInicializar() {
		Speedometer speedometer = mock(Speedometer.class);
		CruiseControl cruiseControl = new CruiseControl(speedometer);
		assertNull(cruiseControl.getSpeedSet());
	}

	@Test
	void speedLimitTieneQueSerNuloAlInicializar() {
		Speedometer speedometer = mock(Speedometer.class);
		CruiseControl cruiseControl = new CruiseControl(speedometer);
		assertNull(cruiseControl.getSpeedLimit());
	}

	@Test
	void speedSetNoPuedeSerCero() {
		Speedometer speedometer = mock(Speedometer.class);
		CruiseControl cruiseControl = new CruiseControl(speedometer);
		assertThrows(IncorrectSpeedSetException.class, () -> cruiseControl.setSpeedSet(0));
	}

	@Test
	void speedSetNoPuedeSerNegativo() {
		Speedometer speedometer = mock(Speedometer.class);
		CruiseControl cruiseControl = new CruiseControl(speedometer);
		assertThrows(IncorrectSpeedSetException.class, () -> cruiseControl.setSpeedSet(-1));
	}

	@Test
	void speedSetNoPuedeSuperarSpeedLimit() {
		Speedometer speedometer = mock(Speedometer.class);
		CruiseControl cruiseControl = new CruiseControl(speedometer);
		cruiseControl.setSpeedLimit(120);
		assertThrows(SpeedSetAboveSpeedLimitException.class, () -> cruiseControl.setSpeedSet(121));
	}
}
