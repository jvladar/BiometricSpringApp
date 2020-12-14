package Futronic;// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: person.proto

public final class PersonOuterClass {
  private PersonOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface PersonOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Person)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string firstname = 1;</code>
     * @return The firstname.
     */
    java.lang.String getFirstname();
    /**
     * <code>string firstname = 1;</code>
     * @return The bytes for firstname.
     */
    com.google.protobuf.ByteString
        getFirstnameBytes();

    /**
     * <code>string lastname = 2;</code>
     * @return The lastname.
     */
    java.lang.String getLastname();
    /**
     * <code>string lastname = 2;</code>
     * @return The bytes for lastname.
     */
    com.google.protobuf.ByteString
        getLastnameBytes();

    /**
     * <code>int32 age = 3;</code>
     * @return The age.
     */
    int getAge();

    /**
     * <code>bytes image = 4;</code>
     * @return The image.
     */
    com.google.protobuf.ByteString getImage();

    /**
     * <code>int32 img_width = 5;</code>
     * @return The imgWidth.
     */
    int getImgWidth();

    /**
     * <code>int32 img_height = 6;</code>
     * @return The imgHeight.
     */
    int getImgHeight();
  }
  /**
   * Protobuf type {@code Person}
   */
  public static final class Person extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:Person)
      PersonOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use Person.newBuilder() to construct.
    private Person(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Person() {
      firstname_ = "";
      lastname_ = "";
      image_ = com.google.protobuf.ByteString.EMPTY;
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new Person();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private Person(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              java.lang.String s = input.readStringRequireUtf8();

              firstname_ = s;
              break;
            }
            case 18: {
              java.lang.String s = input.readStringRequireUtf8();

              lastname_ = s;
              break;
            }
            case 24: {

              age_ = input.readInt32();
              break;
            }
            case 34: {

              image_ = input.readBytes();
              break;
            }
            case 40: {

              imgWidth_ = input.readInt32();
              break;
            }
            case 48: {

              imgHeight_ = input.readInt32();
              break;
            }
            default: {
              if (!parseUnknownField(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return PersonOuterClass.internal_static_Person_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return PersonOuterClass.internal_static_Person_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              PersonOuterClass.Person.class, PersonOuterClass.Person.Builder.class);
    }

    public static final int FIRSTNAME_FIELD_NUMBER = 1;
    private volatile java.lang.Object firstname_;
    /**
     * <code>string firstname = 1;</code>
     * @return The firstname.
     */
    @java.lang.Override
    public java.lang.String getFirstname() {
      java.lang.Object ref = firstname_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        firstname_ = s;
        return s;
      }
    }
    /**
     * <code>string firstname = 1;</code>
     * @return The bytes for firstname.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getFirstnameBytes() {
      java.lang.Object ref = firstname_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        firstname_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int LASTNAME_FIELD_NUMBER = 2;
    private volatile java.lang.Object lastname_;
    /**
     * <code>string lastname = 2;</code>
     * @return The lastname.
     */
    @java.lang.Override
    public java.lang.String getLastname() {
      java.lang.Object ref = lastname_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        lastname_ = s;
        return s;
      }
    }
    /**
     * <code>string lastname = 2;</code>
     * @return The bytes for lastname.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getLastnameBytes() {
      java.lang.Object ref = lastname_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        lastname_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int AGE_FIELD_NUMBER = 3;
    private int age_;
    /**
     * <code>int32 age = 3;</code>
     * @return The age.
     */
    @java.lang.Override
    public int getAge() {
      return age_;
    }

    public static final int IMAGE_FIELD_NUMBER = 4;
    private com.google.protobuf.ByteString image_;
    /**
     * <code>bytes image = 4;</code>
     * @return The image.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString getImage() {
      return image_;
    }

    public static final int IMG_WIDTH_FIELD_NUMBER = 5;
    private int imgWidth_;
    /**
     * <code>int32 img_width = 5;</code>
     * @return The imgWidth.
     */
    @java.lang.Override
    public int getImgWidth() {
      return imgWidth_;
    }

    public static final int IMG_HEIGHT_FIELD_NUMBER = 6;
    private int imgHeight_;
    /**
     * <code>int32 img_height = 6;</code>
     * @return The imgHeight.
     */
    @java.lang.Override
    public int getImgHeight() {
      return imgHeight_;
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (!getFirstnameBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, firstname_);
      }
      if (!getLastnameBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, lastname_);
      }
      if (age_ != 0) {
        output.writeInt32(3, age_);
      }
      if (!image_.isEmpty()) {
        output.writeBytes(4, image_);
      }
      if (imgWidth_ != 0) {
        output.writeInt32(5, imgWidth_);
      }
      if (imgHeight_ != 0) {
        output.writeInt32(6, imgHeight_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getFirstnameBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, firstname_);
      }
      if (!getLastnameBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, lastname_);
      }
      if (age_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(3, age_);
      }
      if (!image_.isEmpty()) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(4, image_);
      }
      if (imgWidth_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(5, imgWidth_);
      }
      if (imgHeight_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(6, imgHeight_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof PersonOuterClass.Person)) {
        return super.equals(obj);
      }
      PersonOuterClass.Person other = (PersonOuterClass.Person) obj;

      if (!getFirstname()
          .equals(other.getFirstname())) return false;
      if (!getLastname()
          .equals(other.getLastname())) return false;
      if (getAge()
          != other.getAge()) return false;
      if (!getImage()
          .equals(other.getImage())) return false;
      if (getImgWidth()
          != other.getImgWidth()) return false;
      if (getImgHeight()
          != other.getImgHeight()) return false;
      if (!unknownFields.equals(other.unknownFields)) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + FIRSTNAME_FIELD_NUMBER;
      hash = (53 * hash) + getFirstname().hashCode();
      hash = (37 * hash) + LASTNAME_FIELD_NUMBER;
      hash = (53 * hash) + getLastname().hashCode();
      hash = (37 * hash) + AGE_FIELD_NUMBER;
      hash = (53 * hash) + getAge();
      hash = (37 * hash) + IMAGE_FIELD_NUMBER;
      hash = (53 * hash) + getImage().hashCode();
      hash = (37 * hash) + IMG_WIDTH_FIELD_NUMBER;
      hash = (53 * hash) + getImgWidth();
      hash = (37 * hash) + IMG_HEIGHT_FIELD_NUMBER;
      hash = (53 * hash) + getImgHeight();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static PersonOuterClass.Person parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static PersonOuterClass.Person parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static PersonOuterClass.Person parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static PersonOuterClass.Person parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static PersonOuterClass.Person parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static PersonOuterClass.Person parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static PersonOuterClass.Person parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static PersonOuterClass.Person parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static PersonOuterClass.Person parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static PersonOuterClass.Person parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static PersonOuterClass.Person parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static PersonOuterClass.Person parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(PersonOuterClass.Person prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code Person}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Person)
        PersonOuterClass.PersonOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return PersonOuterClass.internal_static_Person_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return PersonOuterClass.internal_static_Person_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                PersonOuterClass.Person.class, PersonOuterClass.Person.Builder.class);
      }

      // Construct using com.example.demo.PersonOuterClass.Person.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        firstname_ = "";

        lastname_ = "";

        age_ = 0;

        image_ = com.google.protobuf.ByteString.EMPTY;

        imgWidth_ = 0;

        imgHeight_ = 0;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return PersonOuterClass.internal_static_Person_descriptor;
      }

      @java.lang.Override
      public PersonOuterClass.Person getDefaultInstanceForType() {
        return PersonOuterClass.Person.getDefaultInstance();
      }

      @java.lang.Override
      public PersonOuterClass.Person build() {
        PersonOuterClass.Person result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public PersonOuterClass.Person buildPartial() {
        PersonOuterClass.Person result = new PersonOuterClass.Person(this);
        result.firstname_ = firstname_;
        result.lastname_ = lastname_;
        result.age_ = age_;
        result.image_ = image_;
        result.imgWidth_ = imgWidth_;
        result.imgHeight_ = imgHeight_;
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return super.clone();
      }
      @java.lang.Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof PersonOuterClass.Person) {
          return mergeFrom((PersonOuterClass.Person)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(PersonOuterClass.Person other) {
        if (other == PersonOuterClass.Person.getDefaultInstance()) return this;
        if (!other.getFirstname().isEmpty()) {
          firstname_ = other.firstname_;
          onChanged();
        }
        if (!other.getLastname().isEmpty()) {
          lastname_ = other.lastname_;
          onChanged();
        }
        if (other.getAge() != 0) {
          setAge(other.getAge());
        }
        if (other.getImage() != com.google.protobuf.ByteString.EMPTY) {
          setImage(other.getImage());
        }
        if (other.getImgWidth() != 0) {
          setImgWidth(other.getImgWidth());
        }
        if (other.getImgHeight() != 0) {
          setImgHeight(other.getImgHeight());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        PersonOuterClass.Person parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (PersonOuterClass.Person) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private java.lang.Object firstname_ = "";
      /**
       * <code>string firstname = 1;</code>
       * @return The firstname.
       */
      public java.lang.String getFirstname() {
        java.lang.Object ref = firstname_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          firstname_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string firstname = 1;</code>
       * @return The bytes for firstname.
       */
      public com.google.protobuf.ByteString
          getFirstnameBytes() {
        java.lang.Object ref = firstname_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          firstname_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string firstname = 1;</code>
       * @param value The firstname to set.
       * @return This builder for chaining.
       */
      public Builder setFirstname(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        firstname_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string firstname = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearFirstname() {
        
        firstname_ = getDefaultInstance().getFirstname();
        onChanged();
        return this;
      }
      /**
       * <code>string firstname = 1;</code>
       * @param value The bytes for firstname to set.
       * @return This builder for chaining.
       */
      public Builder setFirstnameBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        firstname_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object lastname_ = "";
      /**
       * <code>string lastname = 2;</code>
       * @return The lastname.
       */
      public java.lang.String getLastname() {
        java.lang.Object ref = lastname_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          lastname_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string lastname = 2;</code>
       * @return The bytes for lastname.
       */
      public com.google.protobuf.ByteString
          getLastnameBytes() {
        java.lang.Object ref = lastname_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          lastname_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string lastname = 2;</code>
       * @param value The lastname to set.
       * @return This builder for chaining.
       */
      public Builder setLastname(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        lastname_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string lastname = 2;</code>
       * @return This builder for chaining.
       */
      public Builder clearLastname() {
        
        lastname_ = getDefaultInstance().getLastname();
        onChanged();
        return this;
      }
      /**
       * <code>string lastname = 2;</code>
       * @param value The bytes for lastname to set.
       * @return This builder for chaining.
       */
      public Builder setLastnameBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        lastname_ = value;
        onChanged();
        return this;
      }

      private int age_ ;
      /**
       * <code>int32 age = 3;</code>
       * @return The age.
       */
      @java.lang.Override
      public int getAge() {
        return age_;
      }
      /**
       * <code>int32 age = 3;</code>
       * @param value The age to set.
       * @return This builder for chaining.
       */
      public Builder setAge(int value) {
        
        age_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 age = 3;</code>
       * @return This builder for chaining.
       */
      public Builder clearAge() {
        
        age_ = 0;
        onChanged();
        return this;
      }

      private com.google.protobuf.ByteString image_ = com.google.protobuf.ByteString.EMPTY;
      /**
       * <code>bytes image = 4;</code>
       * @return The image.
       */
      @java.lang.Override
      public com.google.protobuf.ByteString getImage() {
        return image_;
      }
      /**
       * <code>bytes image = 4;</code>
       * @param value The image to set.
       * @return This builder for chaining.
       */
      public Builder setImage(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        image_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>bytes image = 4;</code>
       * @return This builder for chaining.
       */
      public Builder clearImage() {
        
        image_ = getDefaultInstance().getImage();
        onChanged();
        return this;
      }

      private int imgWidth_ ;
      /**
       * <code>int32 img_width = 5;</code>
       * @return The imgWidth.
       */
      @java.lang.Override
      public int getImgWidth() {
        return imgWidth_;
      }
      /**
       * <code>int32 img_width = 5;</code>
       * @param value The imgWidth to set.
       * @return This builder for chaining.
       */
      public Builder setImgWidth(int value) {
        
        imgWidth_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 img_width = 5;</code>
       * @return This builder for chaining.
       */
      public Builder clearImgWidth() {
        
        imgWidth_ = 0;
        onChanged();
        return this;
      }

      private int imgHeight_ ;
      /**
       * <code>int32 img_height = 6;</code>
       * @return The imgHeight.
       */
      @java.lang.Override
      public int getImgHeight() {
        return imgHeight_;
      }
      /**
       * <code>int32 img_height = 6;</code>
       * @param value The imgHeight to set.
       * @return This builder for chaining.
       */
      public Builder setImgHeight(int value) {
        
        imgHeight_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 img_height = 6;</code>
       * @return This builder for chaining.
       */
      public Builder clearImgHeight() {
        
        imgHeight_ = 0;
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:Person)
    }

    // @@protoc_insertion_point(class_scope:Person)
    private static final PersonOuterClass.Person DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new PersonOuterClass.Person();
    }

    public static PersonOuterClass.Person getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Person>
        PARSER = new com.google.protobuf.AbstractParser<Person>() {
      @java.lang.Override
      public Person parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new Person(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Person> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<Person> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public PersonOuterClass.Person getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Person_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Person_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\014person.proto\"p\n\006Person\022\021\n\tfirstname\030\001 " +
      "\001(\t\022\020\n\010lastname\030\002 \001(\t\022\013\n\003age\030\003 \001(\005\022\r\n\005im" +
      "age\030\004 \001(\014\022\021\n\timg_width\030\005 \001(\005\022\022\n\nimg_heig" +
      "ht\030\006 \001(\005b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_Person_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Person_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Person_descriptor,
        new java.lang.String[] { "Firstname", "Lastname", "Age", "Image", "ImgWidth", "ImgHeight", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
