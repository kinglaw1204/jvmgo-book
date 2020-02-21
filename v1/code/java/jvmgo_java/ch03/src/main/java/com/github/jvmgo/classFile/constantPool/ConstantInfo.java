package com.github.jvmgo.classFile.constantPool;

import com.github.jvmgo.classfile.ClassReader;

public interface ConstantInfo {

    int CONST_TAG_CLASS = 7;
    int CONST_TAG_FIELD_REF = 9;
    int CONST_TAG_METHOD_REF = 10;
    int CONST_TAG_INTERFACE_MTTHOD_REF = 11;
    int CONST_TAG_STRING = 8;
    int CONST_TAG_INTEGER = 3;
    int CONST_TAG_FLOAT = 4;
    int CONST_TAG_LONG = 5;
    int CONST_TAG_DOUBLE = 6;
    int CONST_TAG_NAME_AND_TYPE = 12;
    int CONST_TAG_UTF8 = 1;
    int CONST_TAG_METHOD_HANDLE = 15;
    int CONST_TAG_METHOD_TYPE = 16;
    int CONST_TAG_INVOKE_DYNAMIC = 18;


    String getValue();


    //Factory method
    static ConstantInfo createConstantInfo(int tag, ClassReader reader, com.github.jvmgo.classfile.constantpool.ConstantPool constPool) {
        switch (tag) {
            //数字
            case CONST_TAG_INTEGER:
                return new com.github.jvmgo.classfile.constantpool.ConstantIntegerInfo(reader);
            case CONST_TAG_FLOAT:
                return new com.github.jvmgo.classfile.constantpool.ConstantFloatInfo(reader);
            case CONST_TAG_LONG:
                return new com.github.jvmgo.classfile.constantpool.ConstantLongInfo(reader);
            case CONST_TAG_DOUBLE:
                return new com.github.jvmgo.classfile.constantpool.ConstantDoubleInfo(reader);

            case CONST_TAG_UTF8:
                return new com.github.jvmgo.classfile.constantpool.ConstantUft8Info(reader);

            //以下3个引用UTF8
            case CONST_TAG_STRING:
                return new com.github.jvmgo.classfile.constantpool.ConstantStringInfo(constPool, reader);
            case CONST_TAG_CLASS:
                return new com.github.jvmgo.classfile.constantpool.ConstantClassInfo(constPool, reader);
            case CONST_TAG_NAME_AND_TYPE:
                return new com.github.jvmgo.classfile.constantpool.ConstantNameAndTypeInfo(constPool, reader);

            //以下3个引用CLASS+NAME_AND_TYPE
            case CONST_TAG_FIELD_REF:
                return new ConstantMemberrefInfo(constPool, reader);
            case CONST_TAG_METHOD_REF:
                return new ConstantMemberrefInfo(constPool, reader);
            case CONST_TAG_INTERFACE_MTTHOD_REF:
                return new ConstantMemberrefInfo(constPool, reader);

            //是Java SE 7才添加到class文件中的，目的是支持新增的invokedynamic指令
            case CONST_TAG_METHOD_HANDLE:
                return null;
            case CONST_TAG_METHOD_TYPE:
                return null;
            case CONST_TAG_INVOKE_DYNAMIC:
                return null;

            default:
                throw new ClassFormatError("constant pool tag!");
        }
    }

}
