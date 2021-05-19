package Futronic.openFinger;// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: PreprocessingResponse.proto

public final class PreprocessingResponseOuterClass {
  private PreprocessingResponseOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface PreprocessingResponseOrBuilder extends
      // @@protoc_insertion_point(interface_extends:PreprocessingResponse)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <pre>
     * array of preprocessing results (images after individual processing stages)
     * </pre>
     *
     * <code>repeated .Fingerprint results = 1;</code>
     */
    java.util.List<FingerprintOuterClass.Fingerprint> 
        getResultsList();
    /**
     * <pre>
     * array of preprocessing results (images after individual processing stages)
     * </pre>
     *
     * <code>repeated .Fingerprint results = 1;</code>
     */
    FingerprintOuterClass.Fingerprint getResults(int index);
    /**
     * <pre>
     * array of preprocessing results (images after individual processing stages)
     * </pre>
     *
     * <code>repeated .Fingerprint results = 1;</code>
     */
    int getResultsCount();
    /**
     * <pre>
     * array of preprocessing results (images after individual processing stages)
     * </pre>
     *
     * <code>repeated .Fingerprint results = 1;</code>
     */
    java.util.List<? extends FingerprintOuterClass.FingerprintOrBuilder> 
        getResultsOrBuilderList();
    /**
     * <pre>
     * array of preprocessing results (images after individual processing stages)
     * </pre>
     *
     * <code>repeated .Fingerprint results = 1;</code>
     */
    FingerprintOuterClass.FingerprintOrBuilder getResultsOrBuilder(
        int index);
  }
  /**
   * <pre>
   * message specifying preprocessing OpenFinger response
   * </pre>
   *
   * Protobuf type {@code PreprocessingResponse}
   */
  public static final class PreprocessingResponse extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:PreprocessingResponse)
      PreprocessingResponseOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use PreprocessingResponse.newBuilder() to construct.
    private PreprocessingResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private PreprocessingResponse() {
      results_ = java.util.Collections.emptyList();
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new PreprocessingResponse();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private PreprocessingResponse(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      int mutable_bitField0_ = 0;
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
              if (!((mutable_bitField0_ & 0x00000001) != 0)) {
                results_ = new java.util.ArrayList<FingerprintOuterClass.Fingerprint>();
                mutable_bitField0_ |= 0x00000001;
              }
              results_.add(
                  input.readMessage(FingerprintOuterClass.Fingerprint.parser(), extensionRegistry));
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
        if (((mutable_bitField0_ & 0x00000001) != 0)) {
          results_ = java.util.Collections.unmodifiableList(results_);
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return PreprocessingResponseOuterClass.internal_static_PreprocessingResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return PreprocessingResponseOuterClass.internal_static_PreprocessingResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              PreprocessingResponseOuterClass.PreprocessingResponse.class, PreprocessingResponseOuterClass.PreprocessingResponse.Builder.class);
    }

    public static final int RESULTS_FIELD_NUMBER = 1;
    private java.util.List<FingerprintOuterClass.Fingerprint> results_;
    /**
     * <pre>
     * array of preprocessing results (images after individual processing stages)
     * </pre>
     *
     * <code>repeated .Fingerprint results = 1;</code>
     */
    @java.lang.Override
    public java.util.List<FingerprintOuterClass.Fingerprint> getResultsList() {
      return results_;
    }
    /**
     * <pre>
     * array of preprocessing results (images after individual processing stages)
     * </pre>
     *
     * <code>repeated .Fingerprint results = 1;</code>
     */
    @java.lang.Override
    public java.util.List<? extends FingerprintOuterClass.FingerprintOrBuilder> 
        getResultsOrBuilderList() {
      return results_;
    }
    /**
     * <pre>
     * array of preprocessing results (images after individual processing stages)
     * </pre>
     *
     * <code>repeated .Fingerprint results = 1;</code>
     */
    @java.lang.Override
    public int getResultsCount() {
      return results_.size();
    }
    /**
     * <pre>
     * array of preprocessing results (images after individual processing stages)
     * </pre>
     *
     * <code>repeated .Fingerprint results = 1;</code>
     */
    @java.lang.Override
    public FingerprintOuterClass.Fingerprint getResults(int index) {
      return results_.get(index);
    }
    /**
     * <pre>
     * array of preprocessing results (images after individual processing stages)
     * </pre>
     *
     * <code>repeated .Fingerprint results = 1;</code>
     */
    @java.lang.Override
    public FingerprintOuterClass.FingerprintOrBuilder getResultsOrBuilder(
        int index) {
      return results_.get(index);
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
      for (int i = 0; i < results_.size(); i++) {
        output.writeMessage(1, results_.get(i));
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      for (int i = 0; i < results_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(1, results_.get(i));
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
      if (!(obj instanceof PreprocessingResponseOuterClass.PreprocessingResponse)) {
        return super.equals(obj);
      }
      PreprocessingResponseOuterClass.PreprocessingResponse other = (PreprocessingResponseOuterClass.PreprocessingResponse) obj;

      if (!getResultsList()
          .equals(other.getResultsList())) return false;
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
      if (getResultsCount() > 0) {
        hash = (37 * hash) + RESULTS_FIELD_NUMBER;
        hash = (53 * hash) + getResultsList().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static PreprocessingResponseOuterClass.PreprocessingResponse parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static PreprocessingResponseOuterClass.PreprocessingResponse parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static PreprocessingResponseOuterClass.PreprocessingResponse parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static PreprocessingResponseOuterClass.PreprocessingResponse parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static PreprocessingResponseOuterClass.PreprocessingResponse parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static PreprocessingResponseOuterClass.PreprocessingResponse parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static PreprocessingResponseOuterClass.PreprocessingResponse parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static PreprocessingResponseOuterClass.PreprocessingResponse parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static PreprocessingResponseOuterClass.PreprocessingResponse parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static PreprocessingResponseOuterClass.PreprocessingResponse parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static PreprocessingResponseOuterClass.PreprocessingResponse parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static PreprocessingResponseOuterClass.PreprocessingResponse parseFrom(
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
    public static Builder newBuilder(PreprocessingResponseOuterClass.PreprocessingResponse prototype) {
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
     * <pre>
     * message specifying preprocessing OpenFinger response
     * </pre>
     *
     * Protobuf type {@code PreprocessingResponse}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:PreprocessingResponse)
        PreprocessingResponseOuterClass.PreprocessingResponseOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return PreprocessingResponseOuterClass.internal_static_PreprocessingResponse_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return PreprocessingResponseOuterClass.internal_static_PreprocessingResponse_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                PreprocessingResponseOuterClass.PreprocessingResponse.class, PreprocessingResponseOuterClass.PreprocessingResponse.Builder.class);
      }

      // Construct using Futronic.openFinger.PreprocessingResponseOuterClass.PreprocessingResponse.newBuilder()
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
          getResultsFieldBuilder();
        }
      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        if (resultsBuilder_ == null) {
          results_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          resultsBuilder_.clear();
        }
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return PreprocessingResponseOuterClass.internal_static_PreprocessingResponse_descriptor;
      }

      @java.lang.Override
      public PreprocessingResponseOuterClass.PreprocessingResponse getDefaultInstanceForType() {
        return PreprocessingResponseOuterClass.PreprocessingResponse.getDefaultInstance();
      }

      @java.lang.Override
      public PreprocessingResponseOuterClass.PreprocessingResponse build() {
        PreprocessingResponseOuterClass.PreprocessingResponse result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public PreprocessingResponseOuterClass.PreprocessingResponse buildPartial() {
        PreprocessingResponseOuterClass.PreprocessingResponse result = new PreprocessingResponseOuterClass.PreprocessingResponse(this);
        int from_bitField0_ = bitField0_;
        if (resultsBuilder_ == null) {
          if (((bitField0_ & 0x00000001) != 0)) {
            results_ = java.util.Collections.unmodifiableList(results_);
            bitField0_ = (bitField0_ & ~0x00000001);
          }
          result.results_ = results_;
        } else {
          result.results_ = resultsBuilder_.build();
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
        if (other instanceof PreprocessingResponseOuterClass.PreprocessingResponse) {
          return mergeFrom((PreprocessingResponseOuterClass.PreprocessingResponse)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(PreprocessingResponseOuterClass.PreprocessingResponse other) {
        if (other == PreprocessingResponseOuterClass.PreprocessingResponse.getDefaultInstance()) return this;
        if (resultsBuilder_ == null) {
          if (!other.results_.isEmpty()) {
            if (results_.isEmpty()) {
              results_ = other.results_;
              bitField0_ = (bitField0_ & ~0x00000001);
            } else {
              ensureResultsIsMutable();
              results_.addAll(other.results_);
            }
            onChanged();
          }
        } else {
          if (!other.results_.isEmpty()) {
            if (resultsBuilder_.isEmpty()) {
              resultsBuilder_.dispose();
              resultsBuilder_ = null;
              results_ = other.results_;
              bitField0_ = (bitField0_ & ~0x00000001);
              resultsBuilder_ = 
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                   getResultsFieldBuilder() : null;
            } else {
              resultsBuilder_.addAllMessages(other.results_);
            }
          }
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
        PreprocessingResponseOuterClass.PreprocessingResponse parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (PreprocessingResponseOuterClass.PreprocessingResponse) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private java.util.List<FingerprintOuterClass.Fingerprint> results_ =
        java.util.Collections.emptyList();
      private void ensureResultsIsMutable() {
        if (!((bitField0_ & 0x00000001) != 0)) {
          results_ = new java.util.ArrayList<FingerprintOuterClass.Fingerprint>(results_);
          bitField0_ |= 0x00000001;
         }
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
          FingerprintOuterClass.Fingerprint, FingerprintOuterClass.Fingerprint.Builder, FingerprintOuterClass.FingerprintOrBuilder> resultsBuilder_;

      /**
       * <pre>
       * array of preprocessing results (images after individual processing stages)
       * </pre>
       *
       * <code>repeated .Fingerprint results = 1;</code>
       */
      public java.util.List<FingerprintOuterClass.Fingerprint> getResultsList() {
        if (resultsBuilder_ == null) {
          return java.util.Collections.unmodifiableList(results_);
        } else {
          return resultsBuilder_.getMessageList();
        }
      }
      /**
       * <pre>
       * array of preprocessing results (images after individual processing stages)
       * </pre>
       *
       * <code>repeated .Fingerprint results = 1;</code>
       */
      public int getResultsCount() {
        if (resultsBuilder_ == null) {
          return results_.size();
        } else {
          return resultsBuilder_.getCount();
        }
      }
      /**
       * <pre>
       * array of preprocessing results (images after individual processing stages)
       * </pre>
       *
       * <code>repeated .Fingerprint results = 1;</code>
       */
      public FingerprintOuterClass.Fingerprint getResults(int index) {
        if (resultsBuilder_ == null) {
          return results_.get(index);
        } else {
          return resultsBuilder_.getMessage(index);
        }
      }
      /**
       * <pre>
       * array of preprocessing results (images after individual processing stages)
       * </pre>
       *
       * <code>repeated .Fingerprint results = 1;</code>
       */
      public Builder setResults(
          int index, FingerprintOuterClass.Fingerprint value) {
        if (resultsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureResultsIsMutable();
          results_.set(index, value);
          onChanged();
        } else {
          resultsBuilder_.setMessage(index, value);
        }
        return this;
      }
      /**
       * <pre>
       * array of preprocessing results (images after individual processing stages)
       * </pre>
       *
       * <code>repeated .Fingerprint results = 1;</code>
       */
      public Builder setResults(
          int index, FingerprintOuterClass.Fingerprint.Builder builderForValue) {
        if (resultsBuilder_ == null) {
          ensureResultsIsMutable();
          results_.set(index, builderForValue.build());
          onChanged();
        } else {
          resultsBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <pre>
       * array of preprocessing results (images after individual processing stages)
       * </pre>
       *
       * <code>repeated .Fingerprint results = 1;</code>
       */
      public Builder addResults(FingerprintOuterClass.Fingerprint value) {
        if (resultsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureResultsIsMutable();
          results_.add(value);
          onChanged();
        } else {
          resultsBuilder_.addMessage(value);
        }
        return this;
      }
      /**
       * <pre>
       * array of preprocessing results (images after individual processing stages)
       * </pre>
       *
       * <code>repeated .Fingerprint results = 1;</code>
       */
      public Builder addResults(
          int index, FingerprintOuterClass.Fingerprint value) {
        if (resultsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureResultsIsMutable();
          results_.add(index, value);
          onChanged();
        } else {
          resultsBuilder_.addMessage(index, value);
        }
        return this;
      }
      /**
       * <pre>
       * array of preprocessing results (images after individual processing stages)
       * </pre>
       *
       * <code>repeated .Fingerprint results = 1;</code>
       */
      public Builder addResults(
          FingerprintOuterClass.Fingerprint.Builder builderForValue) {
        if (resultsBuilder_ == null) {
          ensureResultsIsMutable();
          results_.add(builderForValue.build());
          onChanged();
        } else {
          resultsBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /**
       * <pre>
       * array of preprocessing results (images after individual processing stages)
       * </pre>
       *
       * <code>repeated .Fingerprint results = 1;</code>
       */
      public Builder addResults(
          int index, FingerprintOuterClass.Fingerprint.Builder builderForValue) {
        if (resultsBuilder_ == null) {
          ensureResultsIsMutable();
          results_.add(index, builderForValue.build());
          onChanged();
        } else {
          resultsBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <pre>
       * array of preprocessing results (images after individual processing stages)
       * </pre>
       *
       * <code>repeated .Fingerprint results = 1;</code>
       */
      public Builder addAllResults(
          java.lang.Iterable<? extends FingerprintOuterClass.Fingerprint> values) {
        if (resultsBuilder_ == null) {
          ensureResultsIsMutable();
          addAll(
              values, results_);
          onChanged();
        } else {
          resultsBuilder_.addAllMessages(values);
        }
        return this;
      }
      /**
       * <pre>
       * array of preprocessing results (images after individual processing stages)
       * </pre>
       *
       * <code>repeated .Fingerprint results = 1;</code>
       */
      public Builder clearResults() {
        if (resultsBuilder_ == null) {
          results_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
          onChanged();
        } else {
          resultsBuilder_.clear();
        }
        return this;
      }
      /**
       * <pre>
       * array of preprocessing results (images after individual processing stages)
       * </pre>
       *
       * <code>repeated .Fingerprint results = 1;</code>
       */
      public Builder removeResults(int index) {
        if (resultsBuilder_ == null) {
          ensureResultsIsMutable();
          results_.remove(index);
          onChanged();
        } else {
          resultsBuilder_.remove(index);
        }
        return this;
      }
      /**
       * <pre>
       * array of preprocessing results (images after individual processing stages)
       * </pre>
       *
       * <code>repeated .Fingerprint results = 1;</code>
       */
      public FingerprintOuterClass.Fingerprint.Builder getResultsBuilder(
          int index) {
        return getResultsFieldBuilder().getBuilder(index);
      }
      /**
       * <pre>
       * array of preprocessing results (images after individual processing stages)
       * </pre>
       *
       * <code>repeated .Fingerprint results = 1;</code>
       */
      public FingerprintOuterClass.FingerprintOrBuilder getResultsOrBuilder(
          int index) {
        if (resultsBuilder_ == null) {
          return results_.get(index);  } else {
          return resultsBuilder_.getMessageOrBuilder(index);
        }
      }
      /**
       * <pre>
       * array of preprocessing results (images after individual processing stages)
       * </pre>
       *
       * <code>repeated .Fingerprint results = 1;</code>
       */
      public java.util.List<? extends FingerprintOuterClass.FingerprintOrBuilder> 
           getResultsOrBuilderList() {
        if (resultsBuilder_ != null) {
          return resultsBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(results_);
        }
      }
      /**
       * <pre>
       * array of preprocessing results (images after individual processing stages)
       * </pre>
       *
       * <code>repeated .Fingerprint results = 1;</code>
       */
      public FingerprintOuterClass.Fingerprint.Builder addResultsBuilder() {
        return getResultsFieldBuilder().addBuilder(
            FingerprintOuterClass.Fingerprint.getDefaultInstance());
      }
      /**
       * <pre>
       * array of preprocessing results (images after individual processing stages)
       * </pre>
       *
       * <code>repeated .Fingerprint results = 1;</code>
       */
      public FingerprintOuterClass.Fingerprint.Builder addResultsBuilder(
          int index) {
        return getResultsFieldBuilder().addBuilder(
            index, FingerprintOuterClass.Fingerprint.getDefaultInstance());
      }
      /**
       * <pre>
       * array of preprocessing results (images after individual processing stages)
       * </pre>
       *
       * <code>repeated .Fingerprint results = 1;</code>
       */
      public java.util.List<FingerprintOuterClass.Fingerprint.Builder> 
           getResultsBuilderList() {
        return getResultsFieldBuilder().getBuilderList();
      }
      private com.google.protobuf.RepeatedFieldBuilderV3<
          FingerprintOuterClass.Fingerprint, FingerprintOuterClass.Fingerprint.Builder, FingerprintOuterClass.FingerprintOrBuilder> 
          getResultsFieldBuilder() {
        if (resultsBuilder_ == null) {
          resultsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
              FingerprintOuterClass.Fingerprint, FingerprintOuterClass.Fingerprint.Builder, FingerprintOuterClass.FingerprintOrBuilder>(
                  results_,
                  ((bitField0_ & 0x00000001) != 0),
                  getParentForChildren(),
                  isClean());
          results_ = null;
        }
        return resultsBuilder_;
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


      // @@protoc_insertion_point(builder_scope:PreprocessingResponse)
    }

    // @@protoc_insertion_point(class_scope:PreprocessingResponse)
    private static final PreprocessingResponseOuterClass.PreprocessingResponse DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new PreprocessingResponseOuterClass.PreprocessingResponse();
    }

    public static PreprocessingResponseOuterClass.PreprocessingResponse getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<PreprocessingResponse>
        PARSER = new com.google.protobuf.AbstractParser<PreprocessingResponse>() {
      @java.lang.Override
      public PreprocessingResponse parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new PreprocessingResponse(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<PreprocessingResponse> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<PreprocessingResponse> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public PreprocessingResponseOuterClass.PreprocessingResponse getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_PreprocessingResponse_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_PreprocessingResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\033PreprocessingResponse.proto\032\021Fingerpri" +
      "nt.proto\"6\n\025PreprocessingResponse\022\035\n\007res" +
      "ults\030\001 \003(\0132\014.Fingerprintb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          FingerprintOuterClass.getDescriptor(),
        });
    internal_static_PreprocessingResponse_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_PreprocessingResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_PreprocessingResponse_descriptor,
        new java.lang.String[] { "Results", });
    FingerprintOuterClass.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
