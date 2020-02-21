package com.github.jvmgo.classFile.constantPool;

import com.github.jvmgo.classfile.ClassReader;

/**
 * @Author: panda
 * @Date: 2018/10/3 0003 15:19
 * <p>
 * CONSTANT_XXXXref_info {
 * u1 tag;
 * u2 class_index;//指向CONSTANT_Class_info
 * u2 name_and_type_index;//指向CONSTANT_NameAndType_info
 * }
 */
public class ConstantMemberrefInfo implements com.github.jvmgo.classfile.constantpool.ConstantInfo {

    private com.github.jvmgo.classfile.constantpool.ConstantPool constPool;

    private int classIndex;
    private int nameAndTypeIndex;

    public ConstantMemberrefInfo(com.github.jvmgo.classfile.constantpool.ConstantPool aConstPool, ClassReader reader) {
        this.classIndex = reader.nextU2ToInt();
        this.nameAndTypeIndex = reader.nextU2ToInt();
        this.constPool = aConstPool;
    }

    @Override
    public String getValue() {
        return constPool.getUTF8(classIndex)
                + " " + constPool.getUTF8(nameAndTypeIndex);
    }

    @Override
    public String toString() {
//        com.github.jvmgo.classfile.constantpool.ConstantInfo[] constantInfos = constPool.getConstantInfos();
//        com.github.jvmgo.classfile.constantpool.ConstantClassInfo constClassInfo = (com.github.jvmgo.classfile.constantpool.ConstantClassInfo) constantInfos[classIndex];
//        com.github.jvmgo.classfile.constantpool.ConstantNameAndTypeInfo nameAndTypeInfo = (com.github.jvmgo.classfile.constantpool.ConstantNameAndTypeInfo) constantInfos[nameAndTypeIndex];
//        return "ConstantMemberrefInfo{" +
//                constClassInfo + "  " +
//                nameAndTypeInfo +
//                '}';
        return "";
    }

}
