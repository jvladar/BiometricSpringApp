package Futronic.openFinger;// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ExtractionResponse.proto

public final class ExtractionResponseOuterClass {
  private ExtractionResponseOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface ExtractionResponseOrBuilder extends
      // @@protoc_insertion_point(interface_extends:ExtractionResponse)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>.Level2Vector level2vector = 1;</code>
     * @return Whether the level2vector field is set.
     */
    boolean hasLevel2Vector();
    /**
     * <code>.Level2Vector level2vector = 1;</code>
     * @return The level2vector.
     */
    Level2VectorOuterClass.Level2Vector getLevel2Vector();
    /**
     * <code>.Level2Vector level2vector = 1;</code>
     */
    Level2VectorOuterClass.Level2VectorOrBuilder getLevel2VectorOrBuilder();
  }
  /**
   * Protobuf type {@code ExtractionResponse}
   */
  public static final class ExtractionResponse extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:ExtractionResponse)
      ExtractionResponseOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use ExtractionResponse.newBuilder() to construct.
    private ExtractionResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private ExtractionResponse() {
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new ExtractionResponse();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private ExtractionResponse(
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
              Level2VectorOuterClass.Level2Vector.Builder subBuilder = null;
              if (level2Vector_ != null) {
                subBuilder = level2Vector_.toBuilder();
              }
              level2Vector_ = input.readMessage(Level2VectorOuterClass.Level2Vector.parser(), extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(level2Vector_);
                level2Vector_ = subBuilder.buildPartial();
              }

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
      return ExtractionResponseOuterClass.internal_static_ExtractionResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ExtractionResponseOuterClass.internal_static_ExtractionResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ExtractionResponseOuterClass.ExtractionResponse.class, ExtractionResponseOuterClass.ExtractionResponse.Builder.class);
    }

    public static final int LEVEL2VECTOR_FIELD_NUMBER = 1;
    private Level2VectorOuterClass.Level2Vector level2Vector_;
    /**
     * <code>.Level2Vector level2vector = 1;</code>
     * @return Whether the level2vector field is set.
     */
    @java.lang.Override
    public boolean hasLevel2Vector() {
      return level2Vector_ != null;
    }
    /**
     * <code>.Level2Vector level2vector = 1;</code>
     * @return The level2vector.
     */
    @java.lang.Override
    public Level2VectorOuterClass.Level2Vector getLevel2Vector() {
      return level2Vector_ == null ? Level2VectorOuterClass.Level2Vector.getDefaultInstance() : level2Vector_;
    }
    /**
     * <code>.Level2Vector level2vector = 1;</code>
     */
    @java.lang.Override
    public Level2VectorOuterClass.Level2VectorOrBuilder getLevel2VectorOrBuilder() {
      return getLevel2Vector();
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
      if (level2Vector_ != null) {
        output.writeMessage(1, getLevel2Vector());
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (level2Vector_ != null) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(1, getLevel2Vector());
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
      if (!(obj instanceof ExtractionResponseOuterClass.ExtractionResponse)) {
        return super.equals(obj);
      }
      ExtractionResponseOuterClass.ExtractionResponse other = (ExtractionResponseOuterClass.ExtractionResponse) obj;

      if (hasLevel2Vector() != other.hasLevel2Vector()) return false;
      if (hasLevel2Vector()) {
        if (!getLevel2Vector()
            .equals(other.getLevel2Vector())) return false;
      }
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
      if (hasLevel2Vector()) {
        hash = (37 * hash) + LEVEL2VECTOR_FIELD_NUMBER;
        hash = (53 * hash) + getLevel2Vector().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static ExtractionResponseOuterClass.ExtractionResponse parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static ExtractionResponseOuterClass.ExtractionResponse parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static ExtractionResponseOuterClass.ExtractionResponse parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static ExtractionResponseOuterClass.ExtractionResponse parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static ExtractionResponseOuterClass.ExtractionResponse parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static ExtractionResponseOuterClass.ExtractionResponse parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static ExtractionResponseOuterClass.ExtractionResponse parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static ExtractionResponseOuterClass.ExtractionResponse parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static ExtractionResponseOuterClass.ExtractionResponse parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static ExtractionResponseOuterClass.ExtractionResponse parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static ExtractionResponseOuterClass.ExtractionResponse parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static ExtractionResponseOuterClass.ExtractionResponse parseFrom(
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
    public static Builder newBuilder(ExtractionResponseOuterClass.ExtractionResponse prototype) {
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
     * Protobuf type {@code ExtractionResponse}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:ExtractionResponse)
        ExtractionResponseOuterClass.ExtractionResponseOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return ExtractionResponseOuterClass.internal_static_ExtractionResponse_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return ExtractionResponseOuterClass.internal_static_ExtractionResponse_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                ExtractionResponseOuterClass.ExtractionResponse.class, ExtractionResponseOuterClass.ExtractionResponse.Builder.class);
      }

      // Construct using Futronic.openFinger.ExtractionResponseOuterClass.ExtractionResponse.newBuilder()
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
        if (level2VectorBuilder_ == null) {
          level2Vector_ = null;
        } else {
          level2Vector_ = null;
          level2VectorBuilder_ = null;
        }
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return ExtractionResponseOuterClass.internal_static_ExtractionResponse_descriptor;
      }

      @java.lang.Override
      public ExtractionResponseOuterClass.ExtractionResponse getDefaultInstanceForType() {
        return ExtractionResponseOuterClass.ExtractionResponse.getDefaultInstance();
      }

      @java.lang.Override
      public ExtractionResponseOuterClass.ExtractionResponse build() {
        ExtractionResponseOuterClass.ExtractionResponse result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public ExtractionResponseOuterClass.ExtractionResponse buildPartial() {
        ExtractionResponseOuterClass.ExtractionResponse result = new ExtractionResponseOuterClass.ExtractionResponse(this);
        if (level2VectorBuilder_ == null) {
          result.level2Vector_ = level2Vector_;
        } else {
          result.level2Vector_ = level2VectorBuilder_.build();
        }
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
        if (other instanceof ExtractionResponseOuterClass.ExtractionResponse) {
          return mergeFrom((ExtractionResponseOuterClass.ExtractionResponse)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(ExtractionResponseOuterClass.ExtractionResponse other) {
        if (other == ExtractionResponseOuterClass.ExtractionResponse.getDefaultInstance()) return this;
        if (other.hasLevel2Vector()) {
          mergeLevel2Vector(other.getLevel2Vector());
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
        ExtractionResponseOuterClass.ExtractionResponse parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (ExtractionResponseOuterClass.ExtractionResponse) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private Level2VectorOuterClass.Level2Vector level2Vector_;
      private com.google.protobuf.SingleFieldBuilderV3<
          Level2VectorOuterClass.Level2Vector, Level2VectorOuterClass.Level2Vector.Builder, Level2VectorOuterClass.Level2VectorOrBuilder> level2VectorBuilder_;
      /**
       * <code>.Level2Vector level2vector = 1;</code>
       * @return Whether the level2vector field is set.
       */
      public boolean hasLevel2Vector() {
        return level2VectorBuilder_ != null || level2Vector_ != null;
      }
      /**
       * <code>.Level2Vector level2vector = 1;</code>
       * @return The level2vector.
       */
      public Level2VectorOuterClass.Level2Vector getLevel2Vector() {
        if (level2VectorBuilder_ == null) {
          return level2Vector_ == null ? Level2VectorOuterClass.Level2Vector.getDefaultInstance() : level2Vector_;
        } else {
          return level2VectorBuilder_.getMessage();
        }
      }
      /**
       * <code>.Level2Vector level2vector = 1;</code>
       */
      public Builder setLevel2Vector(Level2VectorOuterClass.Level2Vector value) {
        if (level2VectorBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          level2Vector_ = value;
          onChanged();
        } else {
          level2VectorBuilder_.setMessage(value);
        }

        return this;
      }
      /**
       * <code>.Level2Vector level2vector = 1;</code>
       */
      public Builder setLevel2Vector(
          Level2VectorOuterClass.Level2Vector.Builder builderForValue) {
        if (level2VectorBuilder_ == null) {
          level2Vector_ = builderForValue.build();
          onChanged();
        } else {
          level2VectorBuilder_.setMessage(builderForValue.build());
        }

        return this;
      }
      /**
       * <code>.Level2Vector level2vector = 1;</code>
       */
      public Builder mergeLevel2Vector(Level2VectorOuterClass.Level2Vector value) {
        if (level2VectorBuilder_ == null) {
          if (level2Vector_ != null) {
            level2Vector_ =
              Level2VectorOuterClass.Level2Vector.newBuilder(level2Vector_).mergeFrom(value).buildPartial();
          } else {
            level2Vector_ = value;
          }
          onChanged();
        } else {
          level2VectorBuilder_.mergeFrom(value);
        }

        return this;
      }
      /**
       * <code>.Level2Vector level2vector = 1;</code>
       */
      public Builder clearLevel2Vector() {
        if (level2VectorBuilder_ == null) {
          level2Vector_ = null;
          onChanged();
        } else {
          level2Vector_ = null;
          level2VectorBuilder_ = null;
        }

        return this;
      }
      /**
       * <code>.Level2Vector level2vector = 1;</code>
       */
      public Level2VectorOuterClass.Level2Vector.Builder getLevel2VectorBuilder() {
        
        onChanged();
        return getLevel2VectorFieldBuilder().getBuilder();
      }
      /**
       * <code>.Level2Vector level2vector = 1;</code>
       */
      public Level2VectorOuterClass.Level2VectorOrBuilder getLevel2VectorOrBuilder() {
        if (level2VectorBuilder_ != null) {
          return level2VectorBuilder_.getMessageOrBuilder();
        } else {
          return level2Vector_ == null ?
              Level2VectorOuterClass.Level2Vector.getDefaultInstance() : level2Vector_;
        }
      }
      /**
       * <code>.Level2Vector level2vector = 1;</code>
       */
      private com.google.protobuf.SingleFieldBuilderV3<
          Level2VectorOuterClass.Level2Vector, Level2VectorOuterClass.Level2Vector.Builder, Level2VectorOuterClass.Level2VectorOrBuilder> 
          getLevel2VectorFieldBuilder() {
        if (level2VectorBuilder_ == null) {
          level2VectorBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
              Level2VectorOuterClass.Level2Vector, Level2VectorOuterClass.Level2Vector.Builder, Level2VectorOuterClass.Level2VectorOrBuilder>(
                  getLevel2Vector(),
                  getParentForChildren(),
                  isClean());
          level2Vector_ = null;
        }
        return level2VectorBuilder_;
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


      // @@protoc_insertion_point(builder_scope:ExtractionResponse)
    }

    // @@protoc_insertion_point(class_scope:ExtractionResponse)
    private static final ExtractionResponseOuterClass.ExtractionResponse DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new ExtractionResponseOuterClass.ExtractionResponse();
    }

    public static ExtractionResponseOuterClass.ExtractionResponse getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<ExtractionResponse>
        PARSER = new com.google.protobuf.AbstractParser<ExtractionResponse>() {
      @java.lang.Override
      public ExtractionResponse parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new ExtractionResponse(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<ExtractionResponse> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<ExtractionResponse> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public ExtractionResponseOuterClass.ExtractionResponse getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ExtractionResponse_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ExtractionResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\030ExtractionResponse.proto\032\022Level2Vector" +
      ".proto\"9\n\022ExtractionResponse\022#\n\014level2ve" +
      "ctor\030\001 \001(\0132\r.Level2Vectorb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          Level2VectorOuterClass.getDescriptor(),
        });
    internal_static_ExtractionResponse_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ExtractionResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ExtractionResponse_descriptor,
        new java.lang.String[] { "Level2Vector", });
    Level2VectorOuterClass.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}