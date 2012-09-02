Insert into RELATIONSHIP_TYPE
   (REL_TYPE_ID, REL_TYPE_CODE, REL_TYPE_NAME, REL_TYPE_DESC)
 Values
   ('402881e611817b510111817b5906001d', 'PMOC', 'PrimaryMember', 'Primary member of cluster.');
Insert into RELATIONSHIP_TYPE
   (REL_TYPE_ID, REL_TYPE_CODE, REL_TYPE_NAME, REL_TYPE_DESC)
 Values
   ('402881e611817b510111817b59160020', 'SMOC', 'SecondaryMember', 'Secondary member of cluster.');
Insert into RELATIONSHIP_TYPE
   (REL_TYPE_ID, REL_TYPE_CODE, REL_TYPE_NAME, REL_TYPE_DESC)
 Values
   ('402881e611817b510111817b59160023', 'NPT', 'NonPreferred', 'Stands for Non-preferred Term.  Relationship used to denote the target term is non-preferred.');
Insert into RELATIONSHIP_TYPE
   (REL_TYPE_ID, REL_TYPE_CODE, REL_TYPE_NAME, REL_TYPE_DESC)
 Values
   ('402881e611817b510111817b59160026', 'RT', 'RelatedTo', 'Stands for Related To.  Non-directional relationship between 2 items.');
Insert into RELATIONSHIP_TYPE
   (REL_TYPE_ID, REL_TYPE_CODE, REL_TYPE_NAME, REL_TYPE_DESC)
 Values
   ('402881e611817b510111817b59250029', 'ADDR', 'Address1', 'Address of Entity');
COMMIT;
