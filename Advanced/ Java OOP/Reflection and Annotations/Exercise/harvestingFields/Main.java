package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner ( System.in );

		String input;

		while (!"HARVEST".equals ( input = scanner.nextLine () )){
			Class<RichSoilLand> clazz = RichSoilLand.class;

			if ("all".equals ( input )){
				Arrays.stream ( clazz.getDeclaredFields () ).forEach ( Main::fieldPrint );

			}else{
				String typeOfModifier = input;
				Arrays.stream( clazz.getDeclaredFields (  ) )
						.filter ( f -> typeOfModifier.equals ( Modifier.toString ( f.getModifiers ())))
						.forEach ( Main::fieldPrint );

			}
		}
	}
	private static void fieldPrint( Field field ){
		System.out.printf (
				"%s %s %s%n",
				Modifier.toString ( field.getModifiers ()),
				field.getType ().getSimpleName (),
				field.getName ());

	}
}
