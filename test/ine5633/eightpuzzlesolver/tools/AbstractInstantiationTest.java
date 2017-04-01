package ine5633.eightpuzzlesolver.tools;

import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

public abstract class AbstractInstantiationTest {
	
	@Test
	public void shouldThrowInstantiationException() throws Exception{
		
		Constructor<?> constructor = getClassToTest().getDeclaredConstructors()[0];
		constructor.setAccessible(true);
		
		Throwable targetException = null;
		try {
			constructor.newInstance((Object[])null);
		} catch (InvocationTargetException ite) {
			targetException = ite.getTargetException();
		}
		
		assertNotNull(targetException);
		assertEquals(targetException.getClass(), InstantiationException.class);
		}

	public abstract Class<?> getClassToTest();

}
