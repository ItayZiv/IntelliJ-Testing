#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end
#parse("File Header.java")

import edu.wpi.first.wpilibj.command.Subsystem;

public class ${NAME} extends Subsystem{

    public ${NAME}() {
    
    }
    
    @Override
    public void initDefaultCommand() {
    
    }
}
